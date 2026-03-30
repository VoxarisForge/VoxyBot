package com.moovintwo.VoxyBot;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class EnvReader {

    String bot_token;

    public void init() {
        Properties props = new Properties();

        String rootPath = Paths.get("./src/main/resources").normalize().toAbsolutePath().toString();
        String envFilePath = rootPath + "/.env";

        try (FileInputStream inputStream = new FileInputStream(envFilePath)) {
            props.load(inputStream);

            this.bot_token = props.getProperty("BOT_TOKEN");

        } catch (IOException e) {
            System.err.println("Error loading .env file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String getBotToken() {
        return this.bot_token;
    }
}

