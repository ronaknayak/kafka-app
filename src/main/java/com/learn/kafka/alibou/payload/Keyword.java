package com.learn.kafka.alibou.payload;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Keyword {
    private long keywordIndex;
    private String keyword;
}
