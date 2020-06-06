package com.recipe.blog.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.recipe.blog.model.Comment;
import com.recipe.blog.model.Recipe;
import com.recipe.blog.service.CommentService;
import com.recipe.blog.service.RecipeService;
import com.recipe.blog.service.SecurityService;
import com.recipe.blog.service.UserService;
import com.recipe.blog.validator.UserValidator;

@Controller
public class RecipiesController {
	
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private RecipeService recipeService;
    
    @Autowired
    private CommentService commentService;
    
    
    @GetMapping("/recipies")
    public String recipies(Model model) {
		/*
		 * // model.addAttribute("recipies", recipeService.userRecipies(userForm));
		 */    	
//    	List<Recipe> list = new ArrayList<>();
//    	list.addAll(recipeService.getRecipies()); // znajdz wszystkie recipies dla zalogowanego użytkownika i zapisz je do listy
        model.addAttribute("recipeForm", new Recipe());

    	model.addAttribute("recipeList", recipeService.getRecipies());
        return "recipies";
    }
    
    @PostMapping("/recipies")
    public String addRecipies(@ModelAttribute("recipeForm") Recipe recipeForm) {

        recipeService.save(recipeForm);

        return "redirect:/recipies";
    }
    
    @RequestMapping(value = "/recipe/{id}", method = RequestMethod.GET)
    public String getPostWithId(@PathVariable Long id,  Model model) {
    	model.addAttribute("recipeById", recipeService.getRecipeById(id).iterator().next());
    	model.addAttribute("commentToRecipe", commentService.getCommentByRecipeId(id));
    	return "recipe";
    	
    }
    
    @RequestMapping(value = "/recipe/{id}", method = RequestMethod.POST)
    public String addPost(@PathVariable Long id,  Model model, @ModelAttribute("commentForm") Comment commentForm) {
    	commentService.save(commentForm, recipeService.getRecipeById(id).iterator().next());
    	return "redirect:/recipe/"+id;
    	
    }
    
    @GetMapping("/recipe_filter")
    public String getFiltered( Model model) {
//    	model.addAttribute("recipeFilterForm", recipeService.getRecipeById(id).iterator().next());
//    	model.addAttribute("commentToRecipe", commentService.getCommentByRecipeId(id));
    	return "recipefilter";
    }
    @GetMapping("/recipe_filter/{name}")
    public String getFilteredRecipies(@PathVariable String name, Model model) {
//        	model.addAttribute("recipeList", recipeService.getRecipeById(id).iterator().next());
//        	model.addAttribute("commentToRecipe", commentService.getCommentByRecipeId(id));
    	return "recipefilter";
    }
    @PostMapping("/recipe_filter")
    public String filterRecipies(Model model, @ModelAttribute("recipeFilterForm") Recipe recipe) {
    	model.addAttribute("recipeList", recipeService.getRecipiesByFoodKind(recipe.getKindOfFood()));
    	return "redirect:/recipe_filter";
    	
    }
}
