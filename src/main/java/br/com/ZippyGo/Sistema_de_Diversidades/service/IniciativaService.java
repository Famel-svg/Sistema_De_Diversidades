package br.com.ZippyGo.Sistema_de_Diversidades.service;

import br.com.ZippyGo.Sistema_de_Diversidades.dto.IniciativaCadastroDTO;
import br.com.ZippyGo.Sistema_de_Diversidades.dto.IniciativaExibicaoDTO;
import br.com.ZippyGo.Sistema_de_Diversidades.exceptions.ListaVaziaException;
import br.com.ZippyGo.Sistema_de_Diversidades.model.Iniciativa;
import br.com.ZippyGo.Sistema_de_Diversidades.repository.IniciativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class IniciativaService {

    @Autowired
    private IniciativaRepository iniciativaRepository;

    public IniciativaExibicaoDTO gravar(IniciativaCadastroDTO dto) {
        Iniciativa iniciativa = new Iniciativa();
        iniciativa.setNmIniciativa(dto.nmIniciativa());
        iniciativa.setDtIniciativa(LocalDate.parse(dto.dtIniciativa()));
        iniciativa.setTpIniciativa(dto.tpIniciativa());
        return new IniciativaExibicaoDTO(iniciativaRepository.save(iniciativa));
    }

    public List<IniciativaExibicaoDTO> listar() {
        List<Iniciativa> iniciativas = iniciativaRepository.findAll();
        if (iniciativas.isEmpty()) {
            throw new ListaVaziaException("Iniciativas");
        }
        return iniciativas.stream().map(IniciativaExibicaoDTO::new).toList();
    }

    public IniciativaExibicaoDTO buscarPorId(Integer id) {
        return iniciativaRepository.findById(id)
                .map(IniciativaExibicaoDTO::new)
                .orElseThrow(() -> new ListaVaziaException("Iniciativa com id " + id));
    }

    public void deletar(Integer id) {
        if (!iniciativaRepository.existsById(id)) {
            throw new ListaVaziaException("Iniciativa com id " + id);
        }
        iniciativaRepository.deleteById(id);
    }
}