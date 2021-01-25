package com.test.maven;

import com.test.maven.result.JsonResultFile;
import com.test.maven.result.ResultAddable;
import com.test.maven.result.XmlResultFile;
import com.test.maven.util.PropertiesUtil;

public class Runner {
    public void run() {
        new FileNameHandler(getResultFile()).handle();
    }

    private ResultAddable getResultFile() {
        ResultAddable resultAddable = null;
        String result = PropertiesUtil.SINGLETON.getProperties().getProperty("ResultFile");
        if (result.equalsIgnoreCase("xml")) {
            resultAddable = new XmlResultFile();
        }
        if (result.equalsIgnoreCase("json"))
            resultAddable = new JsonResultFile();
        return resultAddable;
    }
}