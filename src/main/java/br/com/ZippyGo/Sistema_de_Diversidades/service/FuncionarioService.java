package br.com.ZippyGo.Sistema_de_Diversidades.service;

import br.com.ZippyGo.Sistema_de_Diversidades.dto.FuncionarioCadastroDTO;
import br.com.ZippyGo.Sistema_de_Diversidades.dto.FuncionarioExibicaoDTO;
import br.com.ZippyGo.Sistema_de_Diversidades.exceptions.ListaVaziaException;
import br.com.ZippyGo.Sistema_de_Diversidades.model.Funcionario;
import br.com.ZippyGo.Sistema_de_Diversidades.repository.FuncionarioRepository;
import br.com.ZippyGo.Sistema_de_Diversidades.repository.GeneroRepository;
import br.com.ZippyGo.Sistema_de_Diversidades.repository.Orientacao_SexualRepository;
import br.com.ZippyGo.Sistema_de_Diversidades.repository.Raca_EtniaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private GeneroRepository generoRepository;
    @Autowired
    private Orientacao_SexualRepository orientacaoSexualRepository;
    @Autowired
    private Raca_EtniaRepository racaEtniaRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public FuncionarioExibicaoDTO gravar(FuncionarioCadastroDTO funcionarioCadastroDTO){
        Funcionario funcionario = new Funcionario();
        funcionario.setNmFuncionario(funcionarioCadastroDTO.nmFuncionario());
        funcionario.setSenhaFuncionario(passwordEncoder.encode(funcionarioCadastroDTO.getsenhaFuncionario()));
        funcionario.setDtContratacao(LocalDate.parse(funcionarioCadastroDTO.dtContratacao()));
        funcionario.setStatusFuncionario(funcionarioCadastroDTO.status_funcionario());

        funcionario.setGenero(generoRepository.findByNmGenero(funcionarioCadastroDTO.genero())
                .orElseThrow(() -> new RuntimeException("Gênero não encontrado")));
        funcionario.setOrientacaoSexual(orientacaoSexualRepository.findByNmOrientacao(funcionarioCadastroDTO.orientacaoSexual())
                .orElseThrow(() -> new RuntimeException("Orientação sexual não encontrada")));
        funcionario.setRacaEtnia(racaEtniaRepository.findByNmRacaEtnia(funcionarioCadastroDTO.racaEtnia())
                .orElseThrow(() -> new RuntimeException("Raça/Etnia não encontrada")));

        return new FuncionarioExibicaoDTO(funcionarioRepository.save(funcionario));
    }

    public List<FuncionarioExibicaoDTO> listar(){
        List<Funcionario> funcionarios = funcionarioRepository.findAll();

        if (funcionarios.isEmpty()) {
            // Lança a exceção personalizada
            throw new ListaVaziaException("Funcionários");
        }

        return funcionarios.stream().map(FuncionarioExibicaoDTO::new).toList();
    }

}
