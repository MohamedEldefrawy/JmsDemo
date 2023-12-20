package com.jms.demo.jmsdemo.sender;

import com.jms.demo.jmsdemo.config.JmsConfig;
import com.jms.demo.jmsdemo.model.HelloWorldMessage;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class HelloWorldSender {
  private final JmsTemplate jmsTemplate;
  private final Logger logger;

  @Scheduled(fixedRate = 2000)
  public void sendMessage() {
    logger.info("Sending Message");
    HelloWorldMessage message = HelloWorldMessage.builder()
        .id(UUID.randomUUID())
        .message("Hello world !!!")
        .build();
    jmsTemplate.convertAndSend(JmsConfig.HELLO_WORLD_QUEUE, message);
  }
}
