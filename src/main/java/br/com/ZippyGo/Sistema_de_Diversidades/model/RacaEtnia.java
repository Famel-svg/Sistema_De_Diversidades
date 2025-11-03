package br.com.ZippyGo.Sistema_de_Diversidades.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "RACA_ETNIA")
public class RacaEtnia {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_PADRAO")
    //Seq_Padrão, usada para Id aumenta de 1 em 1
    @SequenceGenerator(
            name = "SEQ_PADRAO",
            sequenceName = "SEQ_PADRAO",
            allocationSize = 1
    )
    private Integer cd_raca_etnia;

    @Column(name = "NM_RACA_ETNIA")
    private String nm_raca_etnia;

    @OneToMany(mappedBy = "racaEtnia", fetch = FetchType.LAZY)
    private List<Funcionario> funcionarios;

    public Integer getCd_raca_etnia() {
        return cd_raca_etnia;
    }

    public void setCd_raca_etnia(Integer cd_raca_etnia) {
        this.cd_raca_etnia = cd_raca_etnia;
    }

    public String getNm_raca_etnia() {
        return nm_raca_etnia;
    }

    public void setNm_raca_etnia(String nm_raca_etnia) {
        this.nm_raca_etnia = nm_raca_etnia;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
