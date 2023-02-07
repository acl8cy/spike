package com.si.redis.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class PersonController {
    @Autowired
    private MessageGateway messageGateway;

    @PostMapping
    public void sendPersonInformation(@RequestBody Person person) {
        messageGateway.sendMessage(person);
    }
}
