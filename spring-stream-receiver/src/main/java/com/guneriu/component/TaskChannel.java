package com.guneriu.component;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by AB75448 on 05.09.2016.
 */
public interface TaskChannel {

    String OUTPUT = "taskOutput";

    @Output(OUTPUT)
    MessageChannel taskOutput();

}
