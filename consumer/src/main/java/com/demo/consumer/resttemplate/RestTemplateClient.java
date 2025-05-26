package com.demo.consumer.resttemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class RestTemplateClient {
    private final RestTemplate restTemplate;
    private static final String PROVIDER_URL = "http://localhost:8081";

    public RestTemplateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    String getInstanceInfo(){
        return restTemplate.getForObject(PROVIDER_URL+"/instance-info",String.class);
    }

    public String sendEncryptedUserData(Object user) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Object> request = new HttpEntity<>(user, headers);

            // Replace with the actual receiver endpoint
            String targetUrl = PROVIDER_URL + "/receive-user";

            ResponseEntity<String> response = restTemplate.postForEntity(targetUrl, request, String.class);

            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to send user data";
        }
    }
}
