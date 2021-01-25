package com.test.maven.data;

public class JsonData {
    private String configFileName;
    private String executionTime;
    private String files;

    public JsonData(String configFileName, String executionTime, String files) {
        this.configFileName = configFileName;
        this.executionTime = executionTime;
        this.files = files;
    }

    public String getConfigFileName() {
        return configFileName;
    }

    public void setConfigFileName(String configFileName) {
        this.configFileName = configFileName;
    }

    public String getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }
}