package br.com.ZippyGo.Sistema_de_Diversidades.controller;

import br.com.ZippyGo.Sistema_de_Diversidades.model.Genero;
import br.com.ZippyGo.Sistema_de_Diversidades.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/generos")
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepository;

    @GetMapping
    public ResponseEntity<List<Genero>> listarTodos() {
        return ResponseEntity.ok(generoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> buscarPorId(@PathVariable Integer id) {
        return generoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Genero> criar(@RequestBody Genero genero) {
        return ResponseEntity.ok(generoRepository.save(genero));
    }
}