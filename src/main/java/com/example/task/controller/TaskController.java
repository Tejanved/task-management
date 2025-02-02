package com.example.task.controller;

import com.example.task.model.Task;
import com.example.task.repository.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listTasks", taskRepository.findAll());
        return "tasks";
    }

    @GetMapping("/showNewTaskForm")
    public String showNewTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "task_form";
    }

    @PostMapping("/saveTask")
    public String saveTask(@ModelAttribute("task") Task task) {
        taskRepository.save(task);
        return "redirect:/";
    }
}