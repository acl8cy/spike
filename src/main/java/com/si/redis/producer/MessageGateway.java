package com.si.redis.producer;


import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface MessageGateway {
    @Gateway(requestChannel = "inputChannel")
    public <S> void sendMessage(S request);
}
