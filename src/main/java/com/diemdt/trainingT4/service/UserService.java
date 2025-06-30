package com.diemdt.trainingT4.service;

import com.diemdt.trainingT4.model.User;

public interface UserService {
    User registerUser (User user);
    User getUserByEmail(String email);
}
