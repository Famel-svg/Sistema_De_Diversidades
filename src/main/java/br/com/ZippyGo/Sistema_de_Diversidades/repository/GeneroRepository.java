package br.com.ZippyGo.Sistema_de_Diversidades.repository;

import br.com.ZippyGo.Sistema_de_Diversidades.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface GeneroRepository extends JpaRepository<Genero, Integer> {


    Optional<Genero> findByNmGenero(String nm_genero);
}
