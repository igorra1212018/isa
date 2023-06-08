package com.isa.donorapp.messagingrabitmq;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

@Component
public class Receiver {

  private CountDownLatch latch = new CountDownLatch(1);

  public void receiveMessage(byte[] messageBytes) {
	  String messageStr = new String(messageBytes, StandardCharsets.UTF_8);
    System.out.println("Received <" + messageStr + ">");
    latch.countDown();
  }

  public CountDownLatch getLatch() {
    return latch;
  }

}