package com.example.sendingnotification.controller;

import com.example.sendingnotification.util.MakingResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @GetMapping
    ResponseEntity<?> getUserDetails() {
        return new ResponseEntity<>(MakingResponse.makingResponse("200","Successful"), HttpStatus.OK);
    }
}
