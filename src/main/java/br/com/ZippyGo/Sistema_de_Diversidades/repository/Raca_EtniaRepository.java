package br.com.ZippyGo.Sistema_de_Diversidades.repository;

import br.com.ZippyGo.Sistema_de_Diversidades.model.RacaEtnia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface Raca_EtniaRepository extends JpaRepository<RacaEtnia, Integer> {

    Optional<RacaEtnia> findByNmRacaEtnia(String nm_raca_etnia);
}
