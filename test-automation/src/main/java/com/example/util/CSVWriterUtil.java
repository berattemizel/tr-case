package com.example.util;

import com.example.pages.BoutiquePage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriterUtil {

    //Saves the boutique links along with their status codes and load times into a CSV file.
    public static void saveLinksToCSV(List<String> links, String fileName, BoutiquePage boutiquePage) {
        try (FileWriter csvWriter = new FileWriter(fileName)) {
            csvWriter.append("Link,Status Code,Load Time (ms)\n");

            for (String link : links) {
                int statusCode = boutiquePage.getLinkStatusCode(link);
                long loadTime = boutiquePage.getImageLoadTime(link);
                csvWriter.append(link).append(",").append(String.valueOf(statusCode)).append(",").append(String.valueOf(loadTime)).append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
