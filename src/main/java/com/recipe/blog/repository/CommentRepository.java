package com.recipe.blog.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe.blog.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	Set<Comment> findAllByRecipeId(Long id);
	void deleteById(Long id);
}
