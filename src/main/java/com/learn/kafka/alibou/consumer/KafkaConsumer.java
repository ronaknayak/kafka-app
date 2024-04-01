package com.learn.kafka.alibou.consumer;

import com.learn.kafka.alibou.payload.Keyword;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {
    @KafkaListener(topics = "learning-kafka", groupId = "kafka-app-group")
    public void consumeJsonMsg(Keyword keyword) {
        log.info(String.format("Consuming the message from learning Topic:: %s", keyword));
    }

}