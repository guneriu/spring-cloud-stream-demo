package com.guneriu.subscriber;

import com.guneriu.component.CustomerStatusEvent;
import com.guneriu.component.TaskMessage;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import lombok.extern.slf4j.Slf4j;

@EnableBinding(CustomerStatusEvent.class)
@Slf4j
public class MessageConsumerService {

    @StreamListener(CustomerStatusEvent.STATUS_CHANGE)
    public void handle(TaskMessage message) {
        log.info("received message {}", message);
    }

}
