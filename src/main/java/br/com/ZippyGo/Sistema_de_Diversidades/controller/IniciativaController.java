package br.com.ZippyGo.Sistema_de_Diversidades.controller;

import br.com.ZippyGo.Sistema_de_Diversidades.dto.IniciativaCadastroDTO;
import br.com.ZippyGo.Sistema_de_Diversidades.dto.IniciativaExibicaoDTO;
import br.com.ZippyGo.Sistema_de_Diversidades.service.IniciativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IniciativaController {

    @Autowired
    private IniciativaService iniciativaService;

    @GetMapping("/iniciativas")
    public ResponseEntity<List<IniciativaExibicaoDTO>> listarTodos() {
        return ResponseEntity.ok(iniciativaService.listar());
    }

    @GetMapping("/iniciativas/{id}")
    public ResponseEntity<IniciativaExibicaoDTO> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(iniciativaService.buscarPorId(id));
    }

    @PostMapping("/iniciativas")
    public ResponseEntity<IniciativaExibicaoDTO> criar(@RequestBody IniciativaCadastroDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iniciativaService.gravar(dto));
    }

    @DeleteMapping("/iniciativas/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        iniciativaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}