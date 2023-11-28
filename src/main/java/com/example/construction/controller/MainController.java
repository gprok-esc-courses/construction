package com.example.construction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/bcrypt/{password}")
    public String getBcryptHash(@PathVariable String password, Model model) {
        String hashed = passwordEncoder.encode(password);
        model.addAttribute("password", password);
        model.addAttribute("hashed", hashed);
        return "hashed";
    }
}
