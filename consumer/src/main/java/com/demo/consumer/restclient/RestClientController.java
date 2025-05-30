package com.demo.consumer.restclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/rest-client")

public class RestClientController {

    private final ProviderRestClient providerRestClient;

    public RestClientController(ProviderRestClient providerRestClient) {
        this.providerRestClient = providerRestClient;
    }

    @GetMapping("/instance")
    public Mono<String> getInstance(){
//        RestClient restClient = RestClient.create();
//        String response = restClient.get()
//                .uri("http://localhost:8081/instance-info")
//                .retrieve()
//                .body(String.class);
        return providerRestClient.getInstanceInfo();
    }
}