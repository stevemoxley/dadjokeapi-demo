package com.example.demo.services;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DadJokeService {

    Gson gson = new Gson();

    public DadJoke GetDadJoke() throws IOException {
        String dadJokeJson = GetJson("https://icanhazdadjoke.com/");

        DadJoke dadJoke = gson.fromJson(dadJokeJson, DadJoke.class);
        return dadJoke;
    }

    public DadJokeSearch SearchDadJokes(String searchTerm) throws IOException {
        String dadJokeJson = GetJson("https://icanhazdadjoke.com/search?term="+searchTerm);

        DadJokeSearch dadJokeSearch = gson.fromJson(dadJokeJson, DadJokeSearch.class);
        return dadJokeSearch;

    }

    private String GetJson(String webUrl)  throws IOException{
        URL url = new URL(webUrl);
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

        String result = content.toString();
        return result;
    }



}
