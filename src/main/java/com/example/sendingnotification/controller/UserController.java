package com.example.sendingnotification.controller;

import com.example.sendingnotification.dto.request.appside.UserInformationRequest;
import com.example.sendingnotification.dto.response.SimpleResponse;
import com.example.sendingnotification.service.UserService;
import com.example.sendingnotification.util.MakingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    ResponseEntity<SimpleResponse> saveUserDetails(
            UserInformationRequest request
    ){
        userService.saveUserDetails(request);
        return new ResponseEntity<>(MakingResponse.makingResponse("200","Successfully saved!"), HttpStatus.OK);
    }
}
