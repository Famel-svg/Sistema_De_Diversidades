package br.com.ZippyGo.Sistema_de_Diversidades.repository;

import br.com.ZippyGo.Sistema_de_Diversidades.model.OrientacaoSexual;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Orientacao_SexualRepository extends JpaRepository<OrientacaoSexual, Integer> {

    Optional<OrientacaoSexual> findByNmOrientacao(String nm_orientacao);
}
