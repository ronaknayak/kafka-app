package com.learn.kafka.alibou.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic learningTopic() {
        return TopicBuilder
                .name("learning-kafka")
                .partitions(3)
                .build();
    }
}
