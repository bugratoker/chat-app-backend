package com.webSockets.demo.repository;

import com.webSockets.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

    User getUserByEmail(String email);

}
