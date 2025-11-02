package br.com.ZippyGo.Sistema_de_Diversidades.repository;

import br.com.ZippyGo.Sistema_de_Diversidades.model.Orientacao_Sexual;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Orientacao_SexualRepository extends JpaRepository<Orientacao_Sexual, Integer> {

    Optional<Orientacao_Sexual> findByNmOrientacao(String nm_orientacao);
}
