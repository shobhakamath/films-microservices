package com.films.websocket.controller;

import com.films.websocket.model.ReviewMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ReviewsController {

    @MessageMapping("/review.register")
    @SendTo("/topic/public")
    public ReviewMessage register(@Payload ReviewMessage reviewMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", reviewMessage.getSender());
        return reviewMessage;
    }

    @MessageMapping("/review.send")
    @SendTo("/topic/public")
    public ReviewMessage sendMessage(@Payload ReviewMessage reviewMessage) {
        return reviewMessage;
    }
}