package org.example;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpHandlers;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {

        String id = null;
        boolean runPostTrans = false;

        id = null;

        runPostTrans = id == null;

        String baseURL = "https://api.assemblyai.com/v2/transcript/";

        String apiKey = "111";

        Transcript transcript = new Transcript();
        transcript.setId(id);
        transcript.setAudio_url("https://github.com/johnmarty3/JavaAPITutorial/blob/main/Thirsty.mp4?raw=true");

        Gson gson = new Gson();

        String json1 = gson.toJson(transcript);

        System.out.println(json1);

        URI uri1 = null;
        try {
            uri1 = new URI(baseURL);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        HttpRequest request = HttpRequest.newBuilder().
                uri(uri1)
                .header("Authorization", apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(json1))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        // first. post data, create transcript
        try {
            if(runPostTrans) {

                HttpResponse<String> response =
                        httpClient.send(request,
                                HttpResponse.BodyHandlers.ofString());

                transcript = gson.fromJson(response.body(), Transcript.class);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        URI uri2 = null;
        try {
            uri2 = new URI(baseURL + transcript.getId());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        HttpRequest request2 = HttpRequest.newBuilder().
                uri(uri2)
                .header("Authorization", apiKey)
                .build();

        HttpResponse<String> response2 = null;

        try {
             response2 = httpClient.send(request2,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        transcript = gson.fromJson(response2.body(), Transcript.class);

        System.out.println(transcript.getText());
    }
}