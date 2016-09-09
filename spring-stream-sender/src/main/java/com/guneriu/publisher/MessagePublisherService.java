package com.guneriu.publisher;

import com.guneriu.component.CustomerEvent;
import com.guneriu.component.TaskMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Collections;

import lombok.extern.slf4j.Slf4j;

@EnableBinding(CustomerEvent.class)
@Service
@Slf4j
public class MessagePublisherService {

    @Autowired @Qualifier(value = CustomerEvent.STATUS_CHANGE)
    private MessageChannel output;

    public void sendMessage(TaskMessage body) {
        output.send(MessageBuilder.createMessage(body,
                new MessageHeaders(Collections.singletonMap(MessageHeaders.CONTENT_TYPE, "application/json"))));
        log.info("sent the message {}", body);
    }

}
