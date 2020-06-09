package com.cookingbook.service;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookingbook.model.Komentarz;
import com.cookingbook.model.Przepis;
import com.cookingbook.model.User;
import com.cookingbook.repository.KomentarzRepository;

@Service
public class KomentarzServiceImpl implements KomentarzService {

    @Autowired
    private PrzepisService przepisService;
    
	@Autowired
    private KomentarzRepository komentarzRepository;

    @Override
    public Komentarz save(Komentarz komentarz, Przepis przepis) {
    	User user = przepisService.getUser();
    	komentarz.setUser(user);
    	komentarz.setPrzepis(przepis);
    	int number = this.numberOfKomentarzsToPrzepis(przepis.getId());
    	if (number>=5) {
    		this.deleteById(this.smallestIdForPrzepisKomentarz(przepis.getId()));
    	}
        return komentarzRepository.saveAndFlush(komentarz);
    }

	@Override
	public Set<Komentarz> getKomentarzByPrzepisId(Long id) {
		return komentarzRepository.findAllByPrzepisId(id);
	}

	@Override
	public void deleteById(Long id) {
		komentarzRepository.deleteById(id);
		
	}
	
	//get number of komentarze to Przepis based on Przepis id
	private int numberOfKomentarzsToPrzepis(Long id)
	{
		return this.getKomentarzByPrzepisId(id).size();
	}
	// return the smallest id of komentarze based on Przepis id
	private Long smallestIdForPrzepisKomentarz(Long id) {
		Set<Komentarz> komentarze = this.getKomentarzByPrzepisId(id);
		List<Long> ids = new ArrayList<Long>();
		for(Komentarz komentarz :komentarze) {
			ids.add(komentarz.getId());
		}
		Collections.sort(ids); 
		return ids.get(0);
	}
}