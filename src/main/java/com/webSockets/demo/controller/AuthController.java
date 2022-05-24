package com.webSockets.demo.controller;


import com.webSockets.demo.dto.request.LoginRequest;
import com.webSockets.demo.model.User;
import com.webSockets.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
@CrossOrigin
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        User user = userService.getUserByEmail(loginRequest.getEmail());
        if (loginRequest.getPassword().equals(user.getPassword())) {
            return new ResponseEntity<>(user,HttpStatus.ACCEPTED);//202
        } else {
            return new ResponseEntity<>("yanlis yada eksik bilgi",HttpStatus.BAD_REQUEST);//400
        }
    }

}
