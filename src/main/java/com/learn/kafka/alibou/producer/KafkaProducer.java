package com.learn.kafka.alibou.producer;

import com.learn.kafka.alibou.payload.Keyword;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, Keyword> kafkaTemplate;

    public void sendMessage(Keyword keyword) {
        Message<Keyword> message = MessageBuilder
                .withPayload(keyword)
                .setHeader(KafkaHeaders.TOPIC, "learning-kafka")
                .build();
        kafkaTemplate.send(message);
    }
}
