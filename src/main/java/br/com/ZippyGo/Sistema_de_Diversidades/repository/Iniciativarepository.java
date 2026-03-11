package br.com.ZippyGo.Sistema_de_Diversidades.repository;

import br.com.ZippyGo.Sistema_de_Diversidades.model.Iniciativa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IniciativaRepository extends JpaRepository<Iniciativa, Integer> {

    List<Iniciativa> findByTpIniciativa(String tpIniciativa);
}