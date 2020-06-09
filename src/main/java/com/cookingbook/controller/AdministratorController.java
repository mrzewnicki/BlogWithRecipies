package com.cookingbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cookingbook.model.Przepis;
import com.cookingbook.service.PrzepisService;

@Controller
public class AdministratorController {

    @Autowired
    private PrzepisService przepisService;

    @GetMapping("/stronaAdministratora")
    public String admin(Model model) {
        model.addAttribute("przepisIdForm", new Przepis());
        return "stronaAdministratora";
    }
    
    @PostMapping("/stronaAdministratora")
    public String adminUsun(@ModelAttribute("przepisIdForm") Przepis przepisDoUsuniecia, Model model) {
    	try {
    		Long id = Long.parseLong(przepisDoUsuniecia.getPoziomTrudnosci());
    		przepisService.deleteById(id);
		}
		catch (Exception e){}
        return "stronaAdministratora";
    }
}