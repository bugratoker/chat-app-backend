package com.webSockets.demo.service;


import com.webSockets.demo.model.ChatMessage;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public WebSocketService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }


    public void notifyFrontend(final String message){

        simpMessagingTemplate.convertAndSend("/topic/public", message);

    }
}
