package com.example.demo.services;


import com.google.gson.Gson;
import org.springframework.boot.json.GsonJsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DadJokeService {

    public DadJoke GetDadJoke() throws IOException {
        URL url = new URL("https://icanhazdadjoke.com");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();

        while((inputLine = reader.readLine()) != null){
            content.append(inputLine);
        }


        reader.close();
        connection.disconnect();

        String dadJokeJson = content.toString();

        Gson gson = new Gson();
        DadJoke dadJoke = gson.fromJson(dadJokeJson, DadJoke.class);

        return dadJoke;


    }
}
