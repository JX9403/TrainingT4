package com.diemdt.trainingT4.service;

import com.diemdt.trainingT4.exception.ResourceNotFoundException;
import com.diemdt.trainingT4.model.User;
import com.diemdt.trainingT4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User registerUser (User user){
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new IllegalStateException("Email already taken");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(User.Role.USER);

        return userRepository.save(user);
    }
@Override
    public User getUserByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("User not found"));
    }
}
