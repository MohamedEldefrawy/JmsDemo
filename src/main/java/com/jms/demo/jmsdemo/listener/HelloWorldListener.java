package com.jms.demo.jmsdemo.listener;

import com.jms.demo.jmsdemo.config.JmsConfig;
import com.jms.demo.jmsdemo.model.HelloWorldMessage;
import jakarta.jms.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldListener {

  @JmsListener(destination = JmsConfig.HELLO_WORLD_QUEUE)
  public void listen(@Payload HelloWorldMessage helloWorldMessage,
      @Headers MessageHeaders headers, Message message) {

    System.out.println("I Got a Message!!!!!");

    System.out.println(helloWorldMessage);
  }

}
