package br.com.ZippyGo.Sistema_de_Diversidades.repository;

import br.com.ZippyGo.Sistema_de_Diversidades.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import java.util.List;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query("SELECT f FROM Funcionario f JOIN FETCH f.genero JOIN FETCH f.racaEtnia JOIN FETCH f.orientacaoSexual")
    List<Funcionario> findAll();

    @Query("SELECT c FROM Funcionario c WHERE c.nmFuncionario = :nmFuncionario")
    Optional<Funcionario> findByNmFuncionario(@Param("nmFuncionario") String nmFuncionario);

    @Query("SELECT c FROM Funcionario c WHERE c.genero = :genero")
    Optional<Funcionario> findByGenero(@Param("genero") String genero);

    @Query("SELECT c FROM Funcionario c WHERE c.racaEtnia = :racaEtnia")
    Optional<Funcionario> findByRaca(@Param("racaEtnia") String racaEtnia);
}