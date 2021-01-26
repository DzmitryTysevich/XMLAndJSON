package com.test.maven;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.maven.data.JsonData;

import java.io.File;
import java.io.IOException;

public class JsonReader {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonData jsonData = objectMapper.readValue(new File("src/main/resources/result.json"), JsonData.class);
        System.out.println(jsonData);
    }
}