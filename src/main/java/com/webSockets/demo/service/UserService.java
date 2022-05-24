package com.webSockets.demo.service;

import com.webSockets.demo.model.User;
import com.webSockets.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User saveUser(User user){

        return userRepository.save(user);
    }
    public User getUserByEmail(String email){

        return userRepository.getUserByEmail(email);
    }
}
