package com.susanto.beans;

import java.io.DataOutputStream;
import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.URL;

import java.util.Scanner;
public class HttpRestClient {
    private HttpURLConnection restClient;
    private final static String POST = "POST";

    public void connectToServer(String url, String operation) {
        try {
            restClient = (HttpURLConnection) (new URL(url + "/" + operation).openConnection());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String sendPOSTRequest(String requestParameter) {
        return sendRequest(requestParameter, POST);
    }

    public String sendRequest(String requestParameter, String requestMethod) {
        StringBuffer responseBuilder = new StringBuffer();
        try {
            restClient.setRequestMethod(requestMethod);
            restClient.setRequestProperty("User-Agent", "Mozilla/5.0");
            restClient.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            // Send post request
            restClient.setDoOutput(true);
            DataOutputStream writerObject = new DataOutputStream(restClient.getOutputStream());
            writerObject.writeBytes(requestParameter);
            writerObject.flush();
            writerObject.close();

            Scanner scanResponse = new Scanner(restClient.getInputStream());
            while (scanResponse.hasNext()) {
                responseBuilder.append(scanResponse.nextLine());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseBuilder.toString();
    }
}
