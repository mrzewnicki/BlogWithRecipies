package com.cookingbook.service;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.cookingbook.model.Przepis;
import com.cookingbook.model.User;
import com.cookingbook.repository.PrzepisRepository;

@Service
public class PrzepisServiceImpl implements PrzepisService{
    @Autowired
    private PrzepisRepository przepisRepository;
    
    @Autowired
    private UserService userService;
    
	@Override
	public String userPrzepisy(User user) {
		String przepisy = "";
		if(user.getPrzepisy() != null) {
			for(Przepis przepis: user.getPrzepisy())
			{	
				przepisy+=przepis.toString();
			}
		}
		return przepisy;
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
		return userService.findByUsername(username);
	}

	@Override
	public Set<Przepis> getPrzepisy() {
		User user = this.getUser();
		Long id = user.getId();
		return przepisRepository.findAllByUserId(id);
	}
	
    @Override
    public void save(Przepis przepis) {
    	User user = this.getUser();
    	przepis.setUser(user);
        przepisRepository.saveAndFlush(przepis);
    }

	@Override
	public List<Przepis> getAllPrzepisy() {
		return przepisRepository.findAll();
	}

	@Override
	public Set<Przepis> getPrzepisById(Long id) {
		
		return przepisRepository.findAllById(id);
	}

	@Override
	public Set<Przepis> getPrzepisyByUserUsername(String username) {
		return przepisRepository.findAllByUserUsernameContaining(username);
	}

	@Override
	public Set<Przepis> getPrzepisyByPoziomTrudnosci(String poziomTrudnosci) {
		return przepisRepository.findAllBypoziomTrudnosciContaining(poziomTrudnosci);
	}

	@Override
	public Set<Przepis> getPrzepisyByRodzajPotrawy(String rodzajPotrawy) {
		return przepisRepository.findAllByrodzajPotrawyContaining(rodzajPotrawy);
	}

	@Override
	public void deleteById(Long id) {
		przepisRepository.deleteById(id);
	}

	@Override
	public Przepis getJedenPrzepisById(Long id) {
		return przepisRepository.getPrzepisById(id);
	}
	
	
	
}
