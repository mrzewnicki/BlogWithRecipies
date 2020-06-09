package com.cookingbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookingbook.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}