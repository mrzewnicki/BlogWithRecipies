package com.cookingbook.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookingbook.model.Komentarz;

public interface KomentarzRepository extends JpaRepository<Komentarz, Long>{
	Set<Komentarz> findAllByPrzepisId(Long id);
	void deleteById(Long id);
}
