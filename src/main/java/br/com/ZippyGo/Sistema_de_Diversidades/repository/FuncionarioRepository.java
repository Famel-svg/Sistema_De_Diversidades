package br.com.ZippyGo.Sistema_de_Diversidades.repository;

import br.com.ZippyGo.Sistema_de_Diversidades.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    // ✅ Corrigido: usar camelCase
    @Query("SELECT c FROM Funcionario c WHERE c.nmFuncionario = :nmFuncionario")
    Optional<Funcionario> findByNmFuncionario(@Param("nmFuncionario") String nmFuncionario);

    // ✅ Corrigido: parâmetro e campo ajustados
    @Query("SELECT c FROM Funcionario c WHERE c.genero = :genero")
    Optional<Funcionario> findByGenero(@Param("genero") String genero);

    // ✅ Corrigido: usar camelCase
    @Query("SELECT c FROM Funcionario c WHERE c.racaEtnia = :racaEtnia")
    Optional<Funcionario> findByRaca(@Param("racaEtnia") String racaEtnia);
}