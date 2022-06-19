package net.planotes.services;

import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class LogService {

    private FileReader fileReader;
    private File file;

    public void writeLog(String message, String typeOfLog) {
        try {
            Files.write(
                    Paths.get("src/main/resources/logs/logs.txt"),
                    ("\n" + LocalDateTime.now() + " " + typeOfLog + " " + message).getBytes(),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getReadLog() {
        String all = "";
        try {
            file = new File("src/main/resources/logs/logs.txt");
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
