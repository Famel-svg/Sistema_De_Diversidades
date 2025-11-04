package br.com.ZippyGo.Sistema_de_Diversidades.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "RACA_ETNIA")
public class RacaEtnia {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_PADRAO"
    )
    @SequenceGenerator(
            name = "SEQ_PADRAO",
            sequenceName = "SEQ_PADRAO",
            allocationSize = 1
    )
    @Column(name = "CD_RACA_ETNIA")
    private Integer cdRacaEtnia;

    @Column(name = "NM_RACA_ETNIA")
    private String nmRacaEtnia;

    @OneToMany(mappedBy = "racaEtnia", fetch = FetchType.LAZY)
    private List<Funcionario> funcionario;

    // Getters e Setters
    public Integer getCdRacaEtnia() {
        return cdRacaEtnia;
    }

    public void setCdRacaEtnia(Integer cdRacaEtnia) {
        this.cdRacaEtnia = cdRacaEtnia;
    }

    public String getNmRacaEtnia() {
        return nmRacaEtnia;
    }

    public void setNmRacaEtnia(String nmRacaEtnia) {
        this.nmRacaEtnia = nmRacaEtnia;
    }

    public List<Funcionario> getFuncionario() {
        return funcionario;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionario = funcionario;
    }
}