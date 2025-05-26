package com.demo.consumer.controller;

import com.demo.consumer.entity.User;
import com.demo.consumer.resttemplate.RestTemplateClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final RestTemplateClient restTemplateClient;

    public UserController(RestTemplateClient restTemplateClient) {
        this.restTemplateClient = restTemplateClient;
    }

    @PostMapping("/save-user")
    public ResponseEntity<?> getUser(@RequestBody User user){
        try{
            System.out.println("Received User: " + user.getName());

            // Send encrypted user data via RestTemplateClient
            String response = restTemplateClient.sendEncryptedUserData(user);

            return new ResponseEntity<>("User data sent successfully: " + response, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>("Failed to get User data", HttpStatus.BAD_REQUEST);
    }
}
