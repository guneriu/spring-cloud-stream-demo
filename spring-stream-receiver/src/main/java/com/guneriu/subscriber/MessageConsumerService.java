package com.guneriu.subscriber;

import com.guneriu.component.CustomerEvent;
import com.guneriu.component.TaskMessage;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MessageConsumerService {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = CustomerEvent.OUTGOING_QUEUE, durable = "true", autoDelete = "false"), exchange = @Exchange(CustomerEvent.EXCHANGE), key = CustomerEvent.ROUTING_KEY_STATUS_CHANGE))
    public void handleStatusChange(TaskMessage message) {
        log.info("received status change message {}", message);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = CustomerEvent.INCOMING_QUEUE, durable = "true", autoDelete = "false"), exchange = @Exchange(CustomerEvent.EXCHANGE), key = CustomerEvent.ROUTING_KEY_STATUS_UPDATE))
    public void handleStatusUpdate(TaskMessage message) {
        log.info("received status update message {}", message);
    }


}
