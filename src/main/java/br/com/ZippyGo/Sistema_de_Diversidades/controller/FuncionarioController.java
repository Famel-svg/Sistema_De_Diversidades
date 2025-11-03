package br.com.ZippyGo.Sistema_de_Diversidades.controller;


import br.com.ZippyGo.Sistema_de_Diversidades.dto.FuncionarioCadastroDTO;
import br.com.ZippyGo.Sistema_de_Diversidades.dto.FuncionarioExibicaoDTO;
import br.com.ZippyGo.Sistema_de_Diversidades.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/gravar")
    @ResponseStatus(HttpStatus.CREATED)
    public FuncionarioExibicaoDTO gravar(@RequestBody @Valid FuncionarioCadastroDTO funcionarioCadastroDTO){
        return new FuncionarioService().gravar(funcionarioCadastroDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FuncionarioExibicaoDTO> listarTodosOsFuncionarios(){
        return new FuncionarioService().listar();
    }


}
