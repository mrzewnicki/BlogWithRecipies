package com.cookingbook.service;

import com.cookingbook.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}