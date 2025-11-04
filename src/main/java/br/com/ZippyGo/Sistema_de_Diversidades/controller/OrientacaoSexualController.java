package br.com.ZippyGo.Sistema_de_Diversidades.controller;

import br.com.ZippyGo.Sistema_de_Diversidades.model.OrientacaoSexual;
import br.com.ZippyGo.Sistema_de_Diversidades.repository.Orientacao_SexualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orientacoes")
public class OrientacaoSexualController {

    @Autowired
    private Orientacao_SexualRepository orientacaoRepository;

    @GetMapping
    public ResponseEntity<List<OrientacaoSexual>> listarTodos() {
        return ResponseEntity.ok(orientacaoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrientacaoSexual> buscarPorId(@PathVariable Integer id) {
        return orientacaoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrientacaoSexual> criar(@RequestBody OrientacaoSexual orientacao) {
        return ResponseEntity.ok(orientacaoRepository.save(orientacao));
    }
}