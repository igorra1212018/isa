package com.isa.donorapp.messagingrabitmq;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import com.isa.donorapp.model.User;
import com.isa.donorapp.service.SocketService;
import com.isa.donorapp.service.UserService;

@Component
public class Receiver {

	private CountDownLatch latch = new CountDownLatch(1);
  
	@Autowired
	SocketService socketService;
	@Autowired
	UserService userService;

	public void receiveMessage(byte[] messageBytes) {
		String messageStr = new String(messageBytes, StandardCharsets.UTF_8);
		System.out.println("Received <" + messageStr + ">");
		
		System.out.println(SecurityContextHolder.getContext().getAuthentication());
		
		boolean hasRequiredRole = true;
		
		/*Authentication authentiaction = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentiaction == null)
			hasRequiredRole = false;
		else if (authentiaction.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("STAFF"))
				|| authentiaction.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ADMINISTRATOR"))){
			hasRequiredRole = true;
		}*/
		
		if (hasRequiredRole)
			socketService.processMsg(messageStr);
		else
			System.out.println("[Forbidden]");
		latch.countDown();
	}

	public CountDownLatch getLatch() {
		return latch;
	}

	private User getCurrentUser() {
		String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		return userService.findByEmail(currentUserEmail);
	}
}