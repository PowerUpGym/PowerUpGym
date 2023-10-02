package com.example.PowerUpGym.services;

import com.example.PowerUpGym.entity.users.PlayersEntity;
import com.example.PowerUpGym.entity.users.UserEntity;
import com.example.PowerUpGym.repositories.UserEntityRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserEntityRepositories userEntityRepositories;

    public UserService(UserEntityRepositories userEntityRepositories) {
        this.userEntityRepositories = userEntityRepositories;
    }


    public List<UserEntity> getAllUsers() {
        return userEntityRepositories.findAll();
    }

    public UserEntity signupUser(UserEntity user) {
        userEntityRepositories.save(user);
        return user;
    }

    public UserEntity getUserById(Long userId) {
        Optional<UserEntity> userOptional = userEntityRepositories.findById(userId);
        return userOptional.orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }
}
