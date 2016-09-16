package com.guneriu.component;

public interface CustomerEvent {

    String ROUTING_KEY_STATUS_CHANGE = "status_change";

    String ROUTING_KEY_STATUS_UPDATE = "status_update";

    String EXCHANGE = "customer";

    String OUTGOING_QUEUE = "outgoing.queue";

    String INCOMING_QUEUE = "incoming.queue";

}
