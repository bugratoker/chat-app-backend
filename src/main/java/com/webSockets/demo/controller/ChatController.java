package com.webSockets.demo.controller;

import com.webSockets.demo.model.ChatMessage;
import com.webSockets.demo.model.MessageType;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private SimpMessagingTemplate simpMessagingTemplate;

    //vhoever subscribe /chat.send   //message // topic/messages
    //ve are sending message to the /message endpoint
    @MessageMapping("/message")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload final ChatMessage chatMessage){

        return chatMessage;
    }
    /*
    @MessageMapping("/chat.newUser")
    @SendTo("/topic/public")
    public ChatMessage newUser(@Payload final ChatMessage chatMessage,
                               SimpMessageHeaderAccessor simpMessageHeaderAccessor){

        simpMessageHeaderAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        //simpMessageHeaderAccessor.getSessionAttributes().put("messageType",chatMessage.getMessageType());
        // ve are returning chatMesseage object to the topic/public destination
        return chatMessage;
    }
    */

    @MessageMapping("/private-message")
    public ChatMessage receivePrivateMessage(@Payload ChatMessage chatMessage){

        simpMessagingTemplate
                .convertAndSendToUser(
                        chatMessage.getReceiver(),
                        "/private",
                        chatMessage);

        return chatMessage;
    }
    
    
}
