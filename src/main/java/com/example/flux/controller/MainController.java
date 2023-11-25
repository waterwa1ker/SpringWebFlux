package com.example.flux.controller;

import com.example.flux.domain.Message;
import com.example.flux.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/controller")
public class MainController {

    private final MessageService messageService;

    @Autowired
    public MainController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public Flux<Message> list(@RequestParam(defaultValue = "0") Long start,
                              @RequestParam(defaultValue = "3") Long count){
        return messageService.findAll();
    }

    @PostMapping("/add")
    public Mono<Message> addMessage(@RequestBody Message message){
        return messageService.addMessage(message);
    }

}
