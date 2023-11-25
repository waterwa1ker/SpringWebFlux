package com.example.flux.repository;

import com.example.flux.domain.Message;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface MessageRepository extends ReactiveCrudRepository<Message, Integer> {
}
