package com.guneriu.component;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface CustomerEvent {

    String STATUS_CHANGE = "status_change";

    @Input(STATUS_CHANGE)
    MessageChannel output();

}
