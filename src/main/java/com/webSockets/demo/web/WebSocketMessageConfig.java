package com.webSockets.demo.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketMessageConfig implements WebSocketMessageBrokerConfigurer {

//REQUEST
    @Override
    public void registerStompEndpoints(final StompEndpointRegistry stompEndpointRegistry){
//Request URL: http://localhost:8080/chat-example/info?t=1646163459884
        stompEndpointRegistry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();

    }
//DISTRIBUTION
    @Override
    public void configureMessageBroker(final MessageBrokerRegistry messageBrokerRegistry){
        //app'e message sent ederiz
        messageBrokerRegistry.setApplicationDestinationPrefixes("/app");
        //topic üzerinden brokera gelen mesajları çekeriz chatroom => topic
        messageBrokerRegistry.enableSimpleBroker("/topic","/user");
        messageBrokerRegistry.setUserDestinationPrefix("/user");

    }

}
