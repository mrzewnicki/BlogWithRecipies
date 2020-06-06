package com.recipe.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe.blog.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}