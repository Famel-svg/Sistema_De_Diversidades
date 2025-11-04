package br.com.ZippyGo.Sistema_de_Diversidades.controller;

import br.com.ZippyGo.Sistema_de_Diversidades.dto.FuncionarioExibicaoDTO;
import br.com.ZippyGo.Sistema_de_Diversidades.service.FuncionarioService;
import br.com.ZippyGo.Sistema_de_Diversidades.model.Funcionario;
import br.com.ZippyGo.Sistema_de_Diversidades.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // GET - Listar todos os funcionários
    @GetMapping("/funcionarios")
    public ResponseEntity<List<FuncionarioExibicaoDTO>> listarTodos() {
        List<FuncionarioExibicaoDTO> funcionarios = funcionarioService.listar();
        return ResponseEntity.ok(funcionarios);
    }


        // GET - Buscar funcionário por ID
    @GetMapping("/funcionarios/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Integer id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        return funcionario.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET - Buscar funcionário por nome
    @GetMapping("/funcionarios/{nome}")
    public ResponseEntity<Funcionario> buscarPorNome(@PathVariable String nome) {
        Optional<Funcionario> funcionario = funcionarioRepository.findByNmFuncionario(nome);
        return funcionario.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - Criar novo funcionário
    @PostMapping("/funcionarios")
    public ResponseEntity<Funcionario> gravar(@RequestBody Funcionario funcionario) {
        Funcionario novoFuncionario = funcionarioRepository.save(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
    }

    // PUT - Atualizar funcionário
    @PutMapping("/funcionarios/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Integer id,
                                                  @RequestBody Funcionario funcionario) {
        if (!funcionarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        funcionario.setCdFuncionario(id);
        Funcionario atualizado = funcionarioRepository.save(funcionario);
        return ResponseEntity.ok(atualizado);
    }

    // DELETE - Remover funcionário
    @DeleteMapping("/funcionarios/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (!funcionarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        funcionarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}