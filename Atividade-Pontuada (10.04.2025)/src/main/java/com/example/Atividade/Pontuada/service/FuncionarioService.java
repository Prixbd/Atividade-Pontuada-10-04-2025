    package com.example.Atividade.Pontuada.service;

    import com.example.Atividade.Pontuada.model.Funcionario;
    import com.example.Atividade.Pontuada.repository.FuncionarioRepository;
    import jakarta.validation.Valid;
    import org.springframework.stereotype.Service;
    import org.springframework.validation.annotation.Validated;
    import java.util.List;

    @Service
    @Validated
    public class FuncionarioService {
        private FuncionarioRepository funcionarioRepository;

        //construtor
        public FuncionarioService(FuncionarioRepository funcionarioRepository){
            this.funcionarioRepository = funcionarioRepository;
        }

        //Serve para listar os funcionario cadastrado
        public List<Funcionario> listarTodos(){
            return funcionarioRepository.findAll();
        }

        //serve pra salvar os funcionarios e o @Valid pra ver se esta no formato correto
        public Funcionario salvar(@Valid Funcionario funcionario){
            if(funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()){
                throw new RuntimeException("E-mail já cadastrado.");
            }
            return funcionarioRepository.save(funcionario);
        }

        //serve pra atualizar um funcionario existente
        public Funcionario atualizar(@Valid Funcionario funcionario){
            Funcionario funcionarioAtualizar = funcionarioRepository.findById(funcionario.getId())
                    .orElseThrow(() -> new RuntimeException("Funcionario não Encontrado"));

                    funcionarioAtualizar.setNome(funcionario.getNome());
                    funcionarioAtualizar.setCpf(funcionario.getCpf());
                    funcionarioAtualizar.setDataNascimento(funcionario.getDataNascimento());
                    funcionarioAtualizar.setSexo(funcionario.getSexo());
                    funcionarioAtualizar.setSetor(funcionario.getSetor());
                    funcionarioAtualizar.setEstadoCivil(funcionario.getEstadoCivil());
                    funcionarioAtualizar.setSalario(funcionario.getSalario());
                    funcionarioAtualizar.setEmail(funcionario.getEmail());
                    funcionarioAtualizar.setEndereco(funcionario.getEndereco());

                    //serve pra retornar depois da atualizacao
                    return funcionarioRepository.save(funcionarioAtualizar);
        }

        //serve pra excluir um funcionario pelo id dele
        public void excluir(Long id){
            Funcionario funcionario = funcionarioRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));
                    funcionarioRepository.deleteById(funcionario.getId());
        }
    }
