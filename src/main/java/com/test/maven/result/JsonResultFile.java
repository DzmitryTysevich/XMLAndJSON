package com.test.maven.result;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.maven.data.JsonData;
import com.test.maven.util.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import static com.test.maven.service.FileService.SINGLETON;

public class JsonResultFile implements ResultAddable {
    private static final Logger LOGGER = LogManager.getLogger(JsonResultFile.class);

    private void writeJson(long executionTime) {
        String configName = new File("config.xml").getName();
        String time = String.valueOf(executionTime);
        String files = SINGLETON.getOLD_FILES() + Arrays.toString(new File(Constants.CONFIGS_PATH).list());
        JsonData jsonData = new JsonData(configName, time, files);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = null;
        try {
            jsonString = objectMapper.writeValueAsString(jsonData);
        } catch (JsonProcessingException e) {
            LOGGER.error("Exception happen!", e);
        }

        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(Constants.RESULT_JSON));
        } catch (IOException e) {
            LOGGER.error("Exception happen!", e);
        }
        try {
            assert bufferedWriter != null;
            assert jsonString != null;
            bufferedWriter.write(jsonString);
            bufferedWriter.flush();
        } catch (IOException e) {
            LOGGER.error("Exception happen!", e);
        }
    }

    @Override
    public void addResult(long executionTime) {
            writeJson(executionTime);
    }
}