package com.recipe.blog.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe.blog.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{
	Set<Recipe> findAllByUserId(Long id);
	Set<Recipe> findAllById(Long id);
	Set<Recipe> findAllByUserUsername(String username);
	Set<Recipe> findAllByLvl(String username);
	Set<Recipe> findAllByKindOfFood(String username);

}
