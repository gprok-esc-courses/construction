package com.example.construction.controller;

import com.example.construction.model.Task;
import com.example.construction.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Set;

@Controller
public class ManagerController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/manager/tasks/open")
    public String openTasks(Model model) {
        List<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);
        return "open_tasks_all";
    }
}
