package br.com.ZippyGo.Sistema_de_Diversidades.service;

import br.com.ZippyGo.Sistema_de_Diversidades.dto.FuncionarioCadastroDTO;
import br.com.ZippyGo.Sistema_de_Diversidades.dto.FuncionarioExibicaoDTO;
import br.com.ZippyGo.Sistema_de_Diversidades.model.Funcionario;
import br.com.ZippyGo.Sistema_de_Diversidades.repository.FuncionarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioExibicaoDTO gravar(FuncionarioCadastroDTO funcionarioCadastroDTO){
        Funcionario funcionario = new Funcionario();
        BeanUtils.copyProperties(funcionarioCadastroDTO, funcionario);
        return new FuncionarioExibicaoDTO(funcionarioRepository.save(funcionario));
    }

    public List<FuncionarioExibicaoDTO> listar(){
        return funcionarioRepository.findAll().stream().map(FuncionarioExibicaoDTO::new).toList();
    }

}
