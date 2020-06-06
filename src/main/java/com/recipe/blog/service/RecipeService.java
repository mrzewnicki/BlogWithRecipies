package com.recipe.blog.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

import com.recipe.blog.model.Recipe;
import com.recipe.blog.model.User;

public interface RecipeService {
	String userRecipies(User user);
//	UserDetails userName();
	User getUser();
	Set<Recipe> getRecipies();
	void save(Recipe recipe);
	List<Recipe> getAllRecipies();
	Set<Recipe> getRecipeById(Long id);
	Set<Recipe> getRecipiesByUserUsername(String username);
	Set<Recipe> getRecipiesByLvl(String lvl);
	Set<Recipe> getRecipiesByFoodKind(String foodKind);
}
