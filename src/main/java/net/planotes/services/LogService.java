package net.planotes.services;

import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class LogService {

    private FileWriter fileWriter;
    private FileReader fileReader;
    private File file;

    public void writeLog(String message, String typeOfLog) {
        try {
            String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.SSS"));
            file = new File("resources/logs/logs.txt");

            fileWriter = new FileWriter(file);
            fileWriter.write(now + " " + typeOfLog + " " + message);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getReadLog() {
        String all = "";
        try {
            file = new File("resources/logs/logs.txt");
            fileReader = new FileReader(file);

            BufferedReader reader = new BufferedReader(fileReader);
            all += reader.lines();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return all;
    }
}
