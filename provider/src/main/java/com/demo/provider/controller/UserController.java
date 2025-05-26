package com.demo.provider.controller;

import com.demo.provider.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receive-user")
public class UserController {

    @PostMapping
    public ResponseEntity<?> getEncryptUser(@RequestBody User user) {
        System.out.println("Received User:");
        System.out.println("Name: " + user.getName());
        System.out.println("Age: " + user.getAge());


        return ResponseEntity.ok("User received successfully");
    }
}
