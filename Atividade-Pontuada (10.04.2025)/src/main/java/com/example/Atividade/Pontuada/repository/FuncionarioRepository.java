package com.example.Atividade.Pontuada.repository;

import com.example.Atividade.Pontuada.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Criar a interface como repository e puxar a biblioteca JPA para salvar atualizar excluir
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    //serve pra deletar com base no email do funcionario
    Optional<Funcionario> findByEmail(String email);
}
