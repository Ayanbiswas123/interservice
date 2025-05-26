package com.demo.consumer.webclient;

import com.demo.consumer.restclient.ProviderRestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/web-client")
public class WebClientController {
    private final ProviderRestClient providerRestClient;

    public WebClientController(ProviderRestClient providerRestClient) {
        this.providerRestClient = providerRestClient;
    }

    @GetMapping("/instance")
    public Mono<String> getInstance(){
//        WebClient webClient =  WebClient.create();
//        Mono<String> response = webClient.get()
//                .uri("http://localhost:8081/instance-info")
//                .retrieve()
//                .bodyToMono(String.class);

        return providerRestClient.getInstanceInfo();
    }
}
