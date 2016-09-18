package com.guneriu.subscriber;

import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import com.guneriu.component.CustomerEvent;
import com.guneriu.component.TaskMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(CustomerEvent.class)
@Slf4j
public class MessageConsumerService {

    @StreamListener(CustomerEvent.STATUS_CHANGE)
    public void handle(TaskMessage message) {
        if (Integer.valueOf(message.getValue()) % 2 == 0) {
            log.info("received message {}", message);
        } else {
            throw new RuntimeJsonMappingException("hedelek");
        }
    }

}
