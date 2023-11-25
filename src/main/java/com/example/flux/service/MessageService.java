package com.example.flux.service;

import com.example.flux.domain.Message;
import com.example.flux.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Flux<Message> findAll(){
        return messageRepository.findAll();
    }

    public Mono<Message> addMessage(Message message){
        return messageRepository.save(message);
    }
}
