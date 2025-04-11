package com.example.Atividade.Pontuada.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Funcionario {
    @Id//define como chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto incrimente
    private Long id;

    //valida que o nome nao pode ser vazio
    @NotBlank(message = "O Nome não pode estar vazio")
    private String nome;

    //valida que o cpf nao pode ser vazio
    @NotBlank(message = "O CPF não pode estar vazio")
    private String cpf;

    //valida que a data dedeNascimente nao pode ser vazia
    @NotBlank(message = "a DatadeNascimento não pode estar vazio")
    private String dataNascimento;

    //define que este campo e um enum
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Enumerated(EnumType.STRING)
    private Setor setor;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    private Double salario;

    @NotBlank(message = "O Email não pode estar vazio")
    private String email;

    //relacionamento 1 para 1
    //cascade pra ir para todas operacos como (salvar,atualizar,excluir)
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    //construtor vazio
    public Funcionario() {
    }

    //construtor completo
    public Funcionario(Long id, String nome, String cpf, String dataNascimento, Sexo sexo, Setor setor, EstadoCivil estadoCivil, Double salario, String email, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.setor = setor;
        this.estadoCivil = estadoCivil;
        this.salario = salario;
        this.email = email;
        this.endereco = endereco;
    }

    //todos os gets e sets
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", sexo=" + sexo +
                ", setor=" + setor +
                ", estadoCivil=" + estadoCivil +
                ", salario=" + salario +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
