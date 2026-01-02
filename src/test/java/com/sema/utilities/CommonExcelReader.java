package com.sema.utilities;

import java.nio.file.Paths;

public class CommonExcelReader {
    //excel den veri okumam gerektiği zaman

    public static String getExcelPath(String fileName) {
        String projectDir = System.getProperty("user.dir");
        String relativePath = "src/test/resources/testData/" + fileName + ".xlsx";
        return Paths.get(projectDir, relativePath).toString();
    }
}





