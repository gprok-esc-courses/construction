package com.example.construction.controller;

import com.example.construction.dto.TaskDto;
import com.example.construction.model.Task;
import com.example.construction.model.User;
import com.example.construction.repository.TaskRepository;
import com.example.construction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;


    @GetMapping("/employee/tasks")
    public String employeeTasks(Model model) {
        TaskDto taskDto = new TaskDto();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName());
        List<Task> userIncompleteTasks = taskRepository.findAllByUserIdAndCompleted(user.getId(), false);
        model.addAttribute("tasks", userIncompleteTasks);
        model.addAttribute("taskDto", taskDto);
        return "employee_tasks";
    }

    @PostMapping("/employee/add/task")
    public String employeeAddTask(@ModelAttribute TaskDto taskDto) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName());
        Task task = new Task();
        task.setContent(taskDto.getContent());
        task.setCompleted(false);
        task.setUser(user);
        taskRepository.save(task);
        return "redirect:/employee/tasks";
    }

    @GetMapping("/employee/complete/task/{task_id}")
    public String completeTask(@PathVariable Long task_id) {
        Optional<Task> optional = taskRepository.findById(task_id);
        if(optional.isPresent()) {
            Task task = optional.get();
            task.setCompleted(true);
            taskRepository.save(task);
        }
        return "redirect:/employee/tasks";
    }
}
