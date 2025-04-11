package com.example.Atividade.Pontuada.controller;

import com.example.Atividade.Pontuada.model.Funcionario;
import com.example.Atividade.Pontuada.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//setar o endPoint do site
@RequestMapping("/funcionarios  ")
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    //Construtor
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }
    //endPoint Get
    //Serve pra listar todos os funcionario salvos
    @GetMapping
    public List<Funcionario> listartodos() {
        return funcionarioService.listarTodos();
    }

    //endPoint Post Serve pra salvar os funcionarios
    //O @Valid garente validar se esta no modelo funcionario
    //O @Requestbody indica que ele e o corpo da requisicao
    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Funcionario funcionario) {
        funcionarioService.salvar(funcionario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Funcionario Criado Com Sucesso."));
    }

    //Put Serve para atualizar um funcionario ja existente
    @PutMapping
    public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody Funcionario funcionario) {
        funcionarioService.atualizar(funcionario);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Funcionario Atualizado Com Sucesso."));
    }

    //O Delete Serve pra deletar um usuario Existente pelo id
    @DeleteMapping
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id) {
        funcionarioService.excluir(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Funcionario Excluido Com Sucesso."));
    }
}
