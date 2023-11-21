package com.example.construction.controller;

import com.example.construction.model.User;
import com.example.construction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/employee/tasks")
    public String employeeTasks(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName());
        model.addAttribute("tasks", user.getTasks());
        return "employee_tasks";
    }
}
