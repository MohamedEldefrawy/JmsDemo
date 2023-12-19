package com.jms.demo.jmsdemo.sender;

import com.jms.demo.jmsdemo.config.JmsConfig;
import com.jms.demo.jmsdemo.model.HelloWorldMessage;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class HelloWorldSender {
  private final JmsTemplate jmsTemplate;

  @Scheduled(fixedRate = 2000)
  public void sendMessage() {

    System.out.println("Sending Message");

    HelloWorldMessage message = HelloWorldMessage.builder()
        .id(UUID.randomUUID())
        .message("Hello world !!!")
        .build();
    jmsTemplate.convertAndSend(JmsConfig.HELLO_WORLD_QUEUE, message);
  }
}
