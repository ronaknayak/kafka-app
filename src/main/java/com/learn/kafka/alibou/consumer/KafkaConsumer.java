package com.learn.kafka.alibou.consumer;

import com.learn.kafka.alibou.payload.Keyword;
import com.learn.kafka.avro.dto.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {
    @KafkaListener(topics = "learning-kafka", groupId = "kafka-app-group")
    public void consume(Keyword keyword) {
        log.info(String.format("Consuming the message from learning Topic:: %s", keyword));
    }

    @KafkaListener(topics = "learning-kafka-avro", groupId = "kafka-app-group")
    public void consumeAvroMessage(ConsumerRecord<String, Page> consumerRecord) {
        log.info(String.format("Consuming the message from learning-kafka-avro Topic:: %s", consumerRecord.value()));
    }

}