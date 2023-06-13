package com.isa.donorapp.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.isa.donorapp.service.UserService;

public class UserResetScheduler {
	
	@Autowired
    private UserService userService;

    @Scheduled(cron = "0 0 0 1 * *") // U ponoc na pocetku svakog prvog u mesecu
    public void resetUserAttributeMonthly() {
    	userService.resetUserAttributeToZero();
    }
}
