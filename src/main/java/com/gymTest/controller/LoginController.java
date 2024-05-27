package com.gymTest.controller;

import com.gymTest.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        long totalEmployees = funcionarioRepository.count();
        model.addAttribute("totalEmployees", totalEmployees);
        return "dashboard";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("")
    public String index() {
        return "login";
    }
}
