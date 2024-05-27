package com.gymTest.controller;

import com.gymTest.model.FuncionarioEntity;
import com.gymTest.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FuncionarioController {

    @Autowired
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @GetMapping("/funcionarios")
    public String funcionariosPage(Model model) {
        List<FuncionarioEntity> employees = funcionarioRepository.findAll(); // Assuming findAll() method exists in your repository
        model.addAttribute("employees", employees);
        return "funcionarios";
    }
}
