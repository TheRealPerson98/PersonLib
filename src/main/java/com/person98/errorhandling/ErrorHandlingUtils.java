package com.person98.errorhandling;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class ErrorHandlingUtils {

    public static void sendErrorToDiscord(String pluginName, IOException e) {
        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpPost postRequest = new HttpPost("https://discord.com/api/webhooks/1205909967840878633/IpHVsXnP9l7NZT_IAjBdVkn92oZQAwFSGrkqVvThsDBLo_mUP-x6aZL9lCDCoHs7eItL");

            String jsonPayload = buildJsonPayload(pluginName, e);
            StringEntity input = new StringEntity(jsonPayload, StandardCharsets.UTF_8);
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);
            if (response.getStatusLine().getStatusCode() != 204) { // Discord webhook success code is 204
                System.err.println("Failed to send error to Discord: HTTP error code : " + response.getStatusLine().getStatusCode());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static String buildJsonPayload(String pluginName, IOException e) {
        return String.format("{ \"embeds\": [{ \"title\": \"Error in %s\", \"description\": \"```%s```\", \"color\": 15158332 }] }",
                pluginName, e.getMessage());
    }
}