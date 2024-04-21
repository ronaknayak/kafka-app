package com.learn.kafka.alibou.consumer;

import com.learn.kafka.alibou.payload.Keyword;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {
    @KafkaListener(topics = "learning-kafka", groupId = "kafka-app-group",
        topicPartitions = {@TopicPartition(topic = "learning-kafka", partitions = {"2"})})
    public void consumer1(Keyword keyword) {
        log.info(String.format("Consumer1 - Consuming the message from learning Topic:: %s", keyword));
    }

//    @KafkaListener(topics = "learning-kafka", groupId = "kafka-app-group")
//    public void consumer2(Keyword keyword) {
//        log.info(String.format("Consumer2 - Consuming the message from learning Topic:: %s", keyword));
//    }
//
//    @KafkaListener(topics = "learning-kafka", groupId = "kafka-app-group")
//    public void consumer3(Keyword keyword) {
//        log.info(String.format("Consumer3 - Consuming the message from learning Topic:: %s", keyword));
//    }
//
//    @KafkaListener(topics = "learning-kafka", groupId = "kafka-app-group")
//    public void consumer4(Keyword keyword) {
//        log.info(String.format("Consumer4 - Consuming the message from learning Topic:: %s", keyword));
//    }

}