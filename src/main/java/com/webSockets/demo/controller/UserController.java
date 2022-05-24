package com.webSockets.demo.controller;

import com.webSockets.demo.dto.request.UserRegistryRequest;
import com.webSockets.demo.model.User;
import com.webSockets.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user/")
@CrossOrigin
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("save")
    public ResponseEntity<User> saveUser(@RequestBody UserRegistryRequest userReq){


        return new ResponseEntity<>(userService.saveUser(User.builder()
                                    .name(userReq.getName())
                                    .surname(userReq.getSurname())
                                    .email(userReq.getEmail())
                                    .password(userReq.getPassword()).build())
                                    , HttpStatus.CREATED);
    }

}
