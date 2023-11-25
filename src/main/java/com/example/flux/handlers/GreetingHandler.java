package com.example.flux.handlers;

import com.example.flux.domain.Message;
import org.springframework.http.MediaType;
import org.springframework.http.ReactiveHttpOutputMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Optional;

@Component
public class GreetingHandler {

    public Mono<ServerResponse> index(ServerRequest request) {

        Long start = request
                .queryParam("start")
                .map(Long::valueOf)
                .orElse(0L);

        Long count = request
                .queryParam("count")
                .map(Long::valueOf)
                .orElse(3L);

        Flux<Message> flux = Flux
                .just(
                        "Hello, reactive!",
                        "Second post",
                        "Third post"
                )
                .skip(start)
                .take(count)
                .map(Message::new);

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(flux, Message.class);
    }

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse
                .ok()
                .render(
                        "index",
                        Map.of("user", request.queryParam("user").orElse("null"))
                );
    }
}