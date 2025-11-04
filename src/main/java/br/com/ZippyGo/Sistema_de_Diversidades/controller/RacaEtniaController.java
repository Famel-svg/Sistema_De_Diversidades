package br.com.ZippyGo.Sistema_de_Diversidades.controller;

import br.com.ZippyGo.Sistema_de_Diversidades.model.RacaEtnia;
import br.com.ZippyGo.Sistema_de_Diversidades.repository.Raca_EtniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/racas")
public class RacaEtniaController {

    @Autowired
    private Raca_EtniaRepository racaEtniaRepository;

    @GetMapping
    public ResponseEntity<List<RacaEtnia>> listarTodos() {
        return ResponseEntity.ok(racaEtniaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RacaEtnia> buscarPorId(@PathVariable Integer id) {
        return racaEtniaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RacaEtnia> criar(@RequestBody RacaEtnia raca) {
        return ResponseEntity.ok(racaEtniaRepository.save(raca));
    }
}