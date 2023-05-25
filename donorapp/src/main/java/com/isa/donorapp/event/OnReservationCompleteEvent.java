package com.isa.donorapp.event;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.isa.donorapp.model.User;

public class OnReservationCompleteEvent extends ApplicationEvent {
    private String qrCode;
    private User user;

    public OnReservationCompleteEvent(User user, String qrCode) {
        super(user);
        this.user = user;
        this.qrCode = qrCode;
    }

	public String getQRCode() {
		return qrCode;
	}

	public User getUser() {
		return user;
	}

	public void setQRCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
