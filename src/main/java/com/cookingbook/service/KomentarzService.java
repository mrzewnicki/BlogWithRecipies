package com.cookingbook.service;

import java.util.Set;

import com.cookingbook.model.Komentarz;
import com.cookingbook.model.Przepis;

public interface KomentarzService {

    Komentarz save(Komentarz komentarz, Przepis przepis);
    Set<Komentarz> getKomentarzByPrzepisId(Long id);
    void deleteById(Long id);
}