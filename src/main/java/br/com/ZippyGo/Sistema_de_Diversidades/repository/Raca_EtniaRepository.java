package br.com.ZippyGo.Sistema_de_Diversidades.repository;

import br.com.ZippyGo.Sistema_de_Diversidades.model.Raca_Etnia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface Raca_EtniaRepository extends JpaRepository<Raca_Etnia, Integer> {

    Optional<Raca_Etnia> findByNmRacaEtnia(String nm_raca_etnia);
}
