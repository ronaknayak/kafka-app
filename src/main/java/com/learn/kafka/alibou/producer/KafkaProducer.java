package com.learn.kafka.alibou.producer;

import com.learn.kafka.alibou.payload.Keyword;
import com.learn.kafka.avro.dto.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, Keyword> kafkaTemplate;
    private final KafkaTemplate<String, Page> kafkaAvroTemplate;

    public void sendMessage(Keyword keyword) {
        Message<Keyword> message = MessageBuilder
                .withPayload(keyword)
                .setHeader(KafkaHeaders.TOPIC, "learning-kafka")
                .build();
        kafkaTemplate.send(message);
    }

    public void sendAvroMessage(Page page) {
        kafkaAvroTemplate.send("learning-kafka-avro", UUID.randomUUID().toString(), page);
    }
}
