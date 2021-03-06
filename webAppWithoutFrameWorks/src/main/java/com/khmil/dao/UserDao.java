package com.khmil.dao;

import com.khmil.model.User;

public interface UserDao {

    User addUser(User user);

    User findByEmail(String email);

    User findByToken(String token);
}
