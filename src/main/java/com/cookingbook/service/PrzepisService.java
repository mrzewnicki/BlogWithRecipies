package com.cookingbook.service;

import java.util.List;
import java.util.Set;
import com.cookingbook.model.Przepis;
import com.cookingbook.model.User;

public interface PrzepisService {
	String userPrzepisy(User user);
	User getUser();
	Set<Przepis> getPrzepisy();
	void save(Przepis przepis);
	List<Przepis> getAllPrzepisy();
	Set<Przepis> getPrzepisById(Long id);
	Set<Przepis> getPrzepisyByUserUsername(String username);
	Set<Przepis> getPrzepisyByPoziomTrudnosci(String poziomTrudnosci);
	Set<Przepis> getPrzepisyByRodzajPotrawy(String rodzajPotrawy);
	void deleteById(Long id);
	Przepis getJedenPrzepisById(Long id);
}
