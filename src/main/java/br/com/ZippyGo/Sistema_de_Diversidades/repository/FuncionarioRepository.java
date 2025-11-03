package br.com.ZippyGo.Sistema_de_Diversidades.repository;

import br.com.ZippyGo.Sistema_de_Diversidades.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query("SELECT c FROM Funcionario c WHERE c.nmFuncionario = :nm_funcionario")
    Optional<Funcionario> findByNmFuncionario(@Param("nm_funcionario") String nm_funcionario);

    @Query("SELECT c FROM Funcionario c WHERE c.genero = :genero")
    Optional<Funcionario> findByGenero(@Param("cd_gereno") String cd_gereno);

    @Query("SELECT c FROM Funcionario c WHERE c.racaEtnia = :racaEtnia")
    Optional<Funcionario> findByRaca(@Param("cd_raca_etnia") String cd_raca_etnia);
}
