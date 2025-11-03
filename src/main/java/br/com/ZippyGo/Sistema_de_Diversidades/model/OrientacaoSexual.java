package br.com.ZippyGo.Sistema_de_Diversidades.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ORIENTACAO_SEXUAL")
public class OrientacaoSexual {

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
    private Integer cd_orientacao_sexual;

    @Column(name = "nm_orientacao", length = 50)
    private String nm_orientacao_sexual;

    @OneToMany(mappedBy = "orientacaoSexual", fetch = FetchType.LAZY)
    private List<Funcionario> funcionarios;

    public Integer getCd_orientacao_sexual() {
        return cd_orientacao_sexual;
    }

    public void setCd_orientacao_sexual(Integer cd_orientacao_sexual) {
        this.cd_orientacao_sexual = cd_orientacao_sexual;
    }

    public String getNm_orientacao_sexual() {
        return nm_orientacao_sexual;
    }

    public void setNm_orientacao_sexual(String nm_orientacao_sexual) {
        this.nm_orientacao_sexual = nm_orientacao_sexual;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
