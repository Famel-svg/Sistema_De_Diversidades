package br.com.ZippyGo.Sistema_de_Diversidades.repository;

import br.com.ZippyGo.Sistema_de_Diversidades.model.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;


public interface FuncionarioRepository extends JpaRepository<Funcionarios, Integer> {

    @Query("SELECT c FROM Funcionarios c WHERE c.nm_funcionario = :nm_funcionario")
    Optional<Funcionarios> findByNmFuncionario(@Param("nm_funcionario") String nm_funcionario);

    @Query("SELECT c FROM Funcionarios c WHERE c.genero = :genero")
    Optional<Funcionarios> findByGenero(@Param("cd_gereno") String cd_gereno);

    @Query("SELECT c FROM Funcionarios c WHERE c.racaEtnia = :racaEtnia")
    Optional<Funcionarios> findByRaca(@Param("cd_raca_etnia") String cd_raca_etnia);
}
