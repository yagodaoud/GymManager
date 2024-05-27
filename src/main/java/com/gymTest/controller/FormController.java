package com.gymTest.controller;

import com.gymTest.model.FuncionarioEntity;
import com.gymTest.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @Autowired
    private final FuncionarioRepository funcionarioRepository;

    public FormController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @GetMapping("/form")
    public String showForm() {
        return "form";
    }

    @PostMapping("/submit")
    public String handleSubmitForm(String nome, String idade, String tipo, String genero, String ini, String fim) {
        FuncionarioEntity funcionario = new FuncionarioEntity();
        funcionario.setNome(nome);
        funcionario.setIdade(idade);
        funcionario.setTipo(tipo);
        funcionario.setGenero(genero);
        funcionario.setIni(ini);
        funcionario.setFim(fim);
        funcionarioRepository.save(funcionario);

        return "redirect:/funcionarios";
    }
}
