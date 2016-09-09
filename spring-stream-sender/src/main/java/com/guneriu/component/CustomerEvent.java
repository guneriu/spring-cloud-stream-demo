package com.guneriu.component;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CustomerEvent {

    String STATUS_CHANGE = "status_change";

    @Output(STATUS_CHANGE)
    MessageChannel output();

}
