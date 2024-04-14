package com.learn.kafka.alibou.controller;

import com.learn.kafka.alibou.payload.Keyword;
import com.learn.kafka.alibou.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;

    @PostMapping("/produce")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Keyword keyword) {
        for (int i = 0; i < 10000; i++) {
            kafkaProducer.sendMessage(keyword);
        }
        return ResponseEntity.ok("Message queued successfully");
    }
}