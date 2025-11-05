package br.com.ZippyGo.Sistema_de_Diversidades.service;

import br.com.ZippyGo.Sistema_de_Diversidades.Security.JwtUtil;
import br.com.ZippyGo.Sistema_de_Diversidades.dto.LoginRequestDTO;
import br.com.ZippyGo.Sistema_de_Diversidades.model.Funcionario;
import br.com.ZippyGo.Sistema_de_Diversidades.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String login(LoginRequestDTO request) {
        Optional<Funcionario> userOpt = funcionarioRepository.findByNmFuncionario(request.getNomeFuncionario());

        if (userOpt.isPresent()) throw new RuntimeException("Usuário não encontrado");
        Funcionario user = userOpt.get();

        if (!passwordEncoder.matches(request.getSenhaFuncionario(), user.getSenhaFuncionario()))
            throw new RuntimeException("Senha incorreta");

        return jwtUtil.geraToken(user.getNmFuncionario());
    }
}
