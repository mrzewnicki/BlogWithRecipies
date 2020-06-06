package com.recipe.blog.service;

import com.recipe.blog.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}