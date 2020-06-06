package com.recipe.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe.blog.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}