package com.recipe.blog.service.implementation;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.recipe.blog.model.Recipe;
import com.recipe.blog.model.User;
import com.recipe.blog.repository.RecipeRepository;
import com.recipe.blog.repository.UserRepository;
import com.recipe.blog.service.RecipeService;
import com.recipe.blog.service.UserService;
import com.recipe.blog.service.implementation.UserDetailsServiceImpl;

@Service
public class RecipeServiceImpl implements RecipeService{
	
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RecipeRepository recipeRepository;
    
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    
    @Autowired
    private UserService userService;
    
	@Override
	public String userRecipies(User user) {
		String recipies = "";
		if(user.getRecipies() != null) {
			for(Recipe recipe: user.getRecipies())
			{	
				recipies+=recipe.toString();
			}
		}
		return recipies;
	}

	@Override
	public User getUser() {
		String username;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
			} else {
			username = principal.toString();
			}
//		return userDetailsService.loadUserByUsername(username);
		return userService.findByUsername(username); // caly user ze wszystkimi jego parametrami.
	}

	@Override
	public Set<Recipe> getRecipies() {
		User user = this.getUser();
		Long id = user.getId();
		return recipeRepository.findAllByUserId(id);
	}
	
    @Override
    public void save(Recipe recipe) {
    	User user = this.getUser();
    	recipe.setUser(user);
        recipeRepository.saveAndFlush(recipe);
    }

	@Override
	public List<Recipe> getAllRecipies() {
		return recipeRepository.findAll();
	}

	@Override
	public Set<Recipe> getRecipeById(Long id) {
		
		return recipeRepository.findAllById(id);
	}

	@Override
	public Set<Recipe> getRecipiesByUserUsername(String username) {
		return recipeRepository.findAllByUserUsername(username);
	}

	@Override
	public Set<Recipe> getRecipiesByLvl(String lvl) {
		return recipeRepository.findAllByLvl(lvl);
	}

	@Override
	public Set<Recipe> getRecipiesByFoodKind(String foodKind) {
		return recipeRepository.findAllByKindOfFood(foodKind);
	}
	
	
	
}
