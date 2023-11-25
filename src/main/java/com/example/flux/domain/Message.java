package com.example.flux.domain;

import org.springframework.data.annotation.Id;


public class Message {

    @Id
    private Integer id;
    private String data;

    public Message(String data) {
        this.data = data;
    }

    public Message() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
