package com.cookingbook.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.cookingbook.model.User;
import com.cookingbook.service.PrzepisService;
import com.cookingbook.service.SecurityService;
import com.cookingbook.service.UserService;
import com.cookingbook.validator.UserValidator;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private PrzepisService przepisService;

    @GetMapping("/rejestracja")
    public String rejestracja(Model model) {
        model.addAttribute("userForm", new User());

        return "rejestracja";
    }
    
    @PostMapping("/rejestracja")
    public String rejestracja(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "rejestracja";
        }
        
        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model, String blad, String logout) {
        if (blad != null)
            model.addAttribute("blad", "Niepoprawne dane logowania");

        if (logout != null)
            model.addAttribute("wiadomosc", "Wylogowano pomyslnie");

        return "login";
    }

    @GetMapping("/")
    public String main(Model model) {
    	model.addAttribute("listaPrzepisow", przepisService.getAllPrzepisy());
        return "main";
    }
    

}