package com.recipe.blog.service;

import java.util.Set;

import com.recipe.blog.model.Comment;
import com.recipe.blog.model.Recipe;

public interface CommentService {

    Comment save(Comment comment, Recipe recipe);
    Set<Comment> getCommentByRecipeId(Long id);
    void deleteById(Long id);
}