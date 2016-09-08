package com.guneriu.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CustomerStatusEvent {

    String STATUS_CHANGE = "customer.status.change";

    @Output(CustomerStatusEvent.STATUS_CHANGE)
    @Qualifier(value = "customerStatusMessageChannel")
    MessageChannel output();

}
