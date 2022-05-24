package com.webSockets.demo.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class ChatMessage {

    private MessageType messageType;
    private String content;
    private String sender;
    private String receiver;
    private String time;


}
