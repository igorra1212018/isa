package com.isa.donorapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class SocketService {

    @Autowired
    private SimpMessagingTemplate template;
    public void processMsg(String msg) {
        this.template.convertAndSend("/topic/location", msg);
    }
}
