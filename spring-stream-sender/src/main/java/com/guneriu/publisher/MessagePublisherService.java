package com.guneriu.publisher;

import com.guneriu.component.CustomerEvent;
import com.guneriu.component.TaskMessage;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Collections;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MessagePublisherService {

    @Autowired
    AmqpTemplate amqpTemplate;

    public void sendStatusChange(TaskMessage body) {
        body.setValue(body.getValue() + "- " + CustomerEvent.ROUTING_KEY_STATUS_CHANGE);
        amqpTemplate.convertAndSend(CustomerEvent.EXCHANGE, CustomerEvent.ROUTING_KEY_STATUS_CHANGE, MessageBuilder.createMessage(body,
                new MessageHeaders(Collections.singletonMap(MessageHeaders.CONTENT_TYPE, "application/json"))));
        log.info("sent the message {}", body);
    }

    public void sendStatusUpdate(TaskMessage body) {
        body.setValue(body.getValue() + "- " + CustomerEvent.ROUTING_KEY_STATUS_UPDATE);
//        amqpTemplate.convertAndSend(CustomerEvent.EXCHANGE, CustomerEvent.ROUTING_KEY_STATUS_UPDATE, MessageBuilder.createMessage(body,
//                new MessageHeaders(Collections.singletonMap(MessageHeaders.CONTENT_TYPE, "application/json"))));
        amqpTemplate.convertAndSend(CustomerEvent.EXCHANGE, CustomerEvent.ROUTING_KEY_STATUS_UPDATE, new GenericMessage<TaskMessage>(body));
        log.info("sent the message {}", body);
    }

}
