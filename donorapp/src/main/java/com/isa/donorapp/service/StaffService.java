package com.isa.donorapp.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Max;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isa.donorapp.dto.DonationCenterDTO;
import com.isa.donorapp.dto.ProcessesReservationDTO;
import com.isa.donorapp.dto.StaffDTO;
import com.isa.donorapp.dto.StaffQuestionnaireDTO;
import com.isa.donorapp.dto.UserProfileDTO;
import com.isa.donorapp.model.DonationCenter;
import com.isa.donorapp.model.Equipment;
import com.isa.donorapp.model.Location;
import com.isa.donorapp.model.LoyaltyProgram;
import com.isa.donorapp.model.Reservation;
import com.isa.donorapp.model.Role;
import com.isa.donorapp.model.Staff;
import com.isa.donorapp.model.StaffQuestionnaire;
import com.isa.donorapp.model.User;
import com.isa.donorapp.model.Term;
import com.isa.donorapp.model.enums.EBloodType;
import com.isa.donorapp.model.enums.EReservationStatus;
import com.isa.donorapp.model.enums.ERole;
import com.isa.donorapp.repository.DonationCenterRepository;
import com.isa.donorapp.repository.EquipmentRepository;
import com.isa.donorapp.repository.ReservationRepository;
import com.isa.donorapp.repository.RoleRepository;
import com.isa.donorapp.repository.StaffQuestionnaireRepository;
import com.isa.donorapp.repository.UserRepository;

import ch.qos.logback.core.util.ContentTypeUtil;

@Service
public class StaffService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	StaffQuestionnaireRepository staffQuestionnaireRepository;
	@Autowired
	EquipmentRepository equipmentRepository;
	@Autowired
	DonationCenterRepository donationCenterRepository;
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	ReservationService reservationService;
	@Autowired
	TermService termService;
	@Autowired
	LoyaltyProgramService loyaltyProgramService;
	@Autowired
	UserService userService;
	@Autowired
	private PasswordEncoder encoder;
	
	public User findByEmail(String email)
	{
		Optional<User> foundUser = userRepository.findByEmail(email);
		if(foundUser.isEmpty())
			return null;
		else
			return foundUser.get();
	}
	
	public User updateStaff(StaffDTO newData) {
		User user = findByEmail(newData.getEmail());
		
		user.setPassword(encoder.encode(newData.getPassword()));
		//user.setPassword(newData.getPassword());
		user.setEmail(newData.getEmail());
		user.setFirstName(newData.getFirstName());
		user.setLastName(newData.getLastName());
		user.setResidence(new Location(newData.getAddress(), newData.getCity(), newData.getCountry()));
		user.setOccupation(newData.getOccupation());
		user.setOccupationInfo(newData.getOccupationInfo());
		
		userRepository.save(user);
		
		return user;
	}
	
	public List<User> findByCenterId(Integer centerId)
	{
		return userRepository.findByDonationCenterId(centerId);
	}
	
	public User registerStaff(User newStaff, DonationCenter dc)
	{
		User staff = newStaff;
		staff.setPassword(encoder.encode(newStaff.getPassword()));
		Role staffRole = roleRepository.findByName(ERole.STAFF)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		staff.getRoles().add(staffRole);
		staff.setActivated(true);
		staff.setDonationCenter(dc);
		return userRepository.save(staff);
	}
	
	public List<ProcessesReservationDTO> getProcessedUsersForCenter(Integer centerId)
    {
		int reservationId = 0;
        List<ProcessesReservationDTO> dto = new ArrayList<>();
        List<User> allUsers = userRepository.findAll();
        for(User u: allUsers) {
            List<Reservation> allReservations = reservationService.findByUserId(u.getId());
            Term latest = null;
            for(Reservation r: allReservations) {
                if(r.getStatus() == EReservationStatus.PROCESSED && r.getTerm().getCenter().getId() == centerId) {
                    if (latest == null || r.getTerm().getDate().isAfter(latest.getDate()))
                        latest = r.getTerm();
                }
                else
                {
                    continue;
                }
            }
            if (latest != null)
                dto.add(new ProcessesReservationDTO(u, latest));
        }
        return dto;
    }

	public List<ProcessesReservationDTO> getNewReservations(String parse, Integer centerId)
	{
		List<ProcessesReservationDTO> dto = new ArrayList<>();
		 List<User> allUsers = userRepository.findAll();
	        for(User u: allUsers) {
	            List<Reservation> allReservations = reservationService.findByUserId(u.getId());
	            for(Reservation r: allReservations) {
	            	if(r.getStatus() == EReservationStatus.NEW && r.isCanceled() == false) {
	            		if(parse.equals("week")) {
	            			if(r.getTerm().getDate().toLocalDate().isAfter(LocalDate.now().minusDays(1)) && r.getTerm().getDate().toLocalDate().isBefore(LocalDate.of(2023, 06, 18)))
		            			dto.add(new ProcessesReservationDTO(r.getId(), u, r.getTerm()));
	            		}
	            		else if(parse.equals("month")){
	            			if(r.getTerm().getDate().toLocalDate().isAfter(LocalDate.now().minusDays(1)) && r.getTerm().getDate().toLocalDate().isBefore(LocalDate.of(2023, 06, 30)))
	            				dto.add(new ProcessesReservationDTO(r.getId(), u, r.getTerm()));
	            		}
	            		else if(parse.equals("year")) {
	            			if(r.getTerm().getDate().toLocalDate().isAfter(LocalDate.now().minusDays(1)) && r.getTerm().getDate().toLocalDate().isBefore(LocalDate.of(2023, 12, 31)))
	            				dto.add(new ProcessesReservationDTO(r.getId(), u, r.getTerm()));
	            		}
	            		else {
	            			if(r.getTerm().getDate().toLocalDate().isEqual(LocalDate.now()))
	            				dto.add(new ProcessesReservationDTO(r.getId(), u, r.getTerm()));
	            		}
	            			
	            	}
	            	else
	            	{
	            		continue;
	            	}
	            }
	        }
		return dto;
	}
	
	public List<User> findStaffFromCenter(int Center_id)
	{
		List<User> staffs = userRepository.findByDonationCenterId(Center_id);
		return staffs;
	}

	@Transactional
	public void startAppointment(StaffQuestionnaire questionnaire, DonationCenter donationCenter, List<Equipment> equipment, Reservation reservation) {
		System.out.println("ovde6.1");
		for(Equipment e: equipment) {
			Equipment newEquipment = equipmentRepository.findById(e.getId()).get();
			newEquipment.setQuantity(Math.max(0,(newEquipment.getQuantity() - e.getQuantity())));
			System.out.println("ovde6");
			equipmentRepository.save(newEquipment);
		}
			
		System.out.println("ovde6.5");
		staffQuestionnaireRepository.save(questionnaire);
		System.out.println("ovde6.6");
		if(questionnaire.getKrvnaGrupa() == EBloodType.A) {
			donationCenter.setBlood_A(donationCenter.getBlood_A() + questionnaire.getKolicinaUzeteKrvi());
			System.out.println("ovde7");
			donationCenterRepository.save(donationCenter);
		}else if(questionnaire.getKrvnaGrupa() == EBloodType.AB) {
			donationCenter.setBlood_AB(donationCenter.getBlood_AB() + questionnaire.getKolicinaUzeteKrvi());
			donationCenterRepository.save(donationCenter);
		}else if(questionnaire.getKrvnaGrupa() == EBloodType.B) {
			donationCenter.setBlood_B(donationCenter.getBlood_A() + questionnaire.getKolicinaUzeteKrvi());
			donationCenterRepository.save(donationCenter);
		}else {
			donationCenter.setBlood_O(donationCenter.getBlood_O() + questionnaire.getKolicinaUzeteKrvi());
			donationCenterRepository.save(donationCenter);
		}
		
		reservation.setStatus(EReservationStatus.PROCESSED);
		System.out.println("ovde8");
		reservationRepository.save(reservation);
		
		User donator = reservation.getUser();
		LoyaltyProgram lp = loyaltyProgramService.getLoyaltyProgram();
		donator.setLoyaltyPoints(donator.getLoyaltyPoints() + lp.getPointsPerDonation());
		userService.save(donator);
	}

	public List<Equipment> getEquipmentByCenterId(Integer centerId) {
		List<Equipment> equipment = equipmentRepository.findByDonationCenterId(centerId);
		return equipment;
	}
		
}
