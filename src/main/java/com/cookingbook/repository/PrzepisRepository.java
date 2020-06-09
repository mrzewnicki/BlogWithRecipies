package com.cookingbook.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookingbook.model.Przepis;

public interface PrzepisRepository extends JpaRepository<Przepis, Long>{
	Przepis getPrzepisById(Long id);
	Set<Przepis> findAllByUserId(Long id);
	Set<Przepis> findAllById(Long id);
	Set<Przepis> findAllByUserUsernameContaining(String username);
	Set<Przepis> findAllBypoziomTrudnosciContaining(String poziomTrudnosci);
	Set<Przepis> findAllByrodzajPotrawyContaining(String rodzajPotrawy);
	void deleteById(Long id);
}
