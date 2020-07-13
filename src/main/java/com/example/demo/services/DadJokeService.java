package com.example.demo.services;


import com.google.gson.Gson;
import com.google.gson.internal.$Gson$Preconditions;
import org.springframework.boot.json.GsonJsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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

    public DadJokeSearch SearchDadJokes(String searchString) throws IOException{
        URL url = new URL("https://icanhazdadjoke.com/search?term="+searchString);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();

        while((inputLine = reader.readLine()) != null){
            content.append(inputLine);
        }

        String dadJokeJson = content.toString();


        reader.close();
        connection.disconnect();

        Gson gson = new Gson();
        DadJokeSearch searchResults = gson.fromJson(dadJokeJson, DadJokeSearch.class);

        return searchResults;
    }
}
