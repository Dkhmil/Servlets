package com.khmil.service;

import com.khmil.model.User;

public interface UserService {

    User addUser(User user);

    User findByEmail(String email);

    boolean validatePassword(User user, String password);
}
