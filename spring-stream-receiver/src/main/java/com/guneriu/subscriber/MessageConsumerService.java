package com.guneriu.subscriber;

import com.guneriu.component.CustomerEvent;
import com.guneriu.component.TaskMessage;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import lombok.extern.slf4j.Slf4j;

@EnableBinding(CustomerEvent.class)
@Slf4j
public class MessageConsumerService {

    @StreamListener(CustomerEvent.STATUS_CHANGE)
    public void handle(TaskMessage message) {
//        if (Integer.valueOf(message.getValue()) % 2 == 0) {
            log.info("received message {}", message);
//        } else {
//            throw new RuntimeJsonMappingException("hedelek");
//        }
    }

}
