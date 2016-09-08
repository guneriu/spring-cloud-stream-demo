package com.guneriu.component;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface CreditStatusEvent {

    String STATUS_CHANGE = "customer.status.change";

    @Input(CreditStatusEvent.STATUS_CHANGE)
    MessageChannel input();

}
