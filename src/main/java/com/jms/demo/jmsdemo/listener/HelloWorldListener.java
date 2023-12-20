package com.jms.demo.jmsdemo.listener;

import com.jms.demo.jmsdemo.config.JmsConfig;
import com.jms.demo.jmsdemo.model.HelloWorldMessage;
import jakarta.jms.Message;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HelloWorldListener {

  private final Logger logger;

  @JmsListener(destination = JmsConfig.HELLO_WORLD_QUEUE)
  public void listen(@Payload HelloWorldMessage helloWorldMessage,
      @Headers MessageHeaders headers, Message message) {

    logger.info("I Got a Message!!!!!");

    logger.info(helloWorldMessage.toString());
  }

}
