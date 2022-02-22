package com.github.sufann.learning.jackson.annotation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sufann
 */
public class QuickStart {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        write();
        read();
    }

    private static void write() throws JsonProcessingException {
        final String jsonStr = OBJECT_MAPPER.writeValueAsString(new QuickStartBean("John", 23));
        System.out.println(jsonStr);
    }

    private static void read() throws JsonProcessingException {
        final String jsonStr = "{\"name\":\"John\",\"age\":23}";
        final QuickStartBean quickStartObject = OBJECT_MAPPER.readValue(jsonStr,
                QuickStartBean.class);
        System.out.println(quickStartObject);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class QuickStartBean {
        private String name;
        private Integer age;
    }

}
