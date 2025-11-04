package br.com.ZippyGo.Sistema_de_Diversidades.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "ORIENTACAO_SEXUAL")
public class OrientacaoSexual {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PADRAO")
    @SequenceGenerator(name = "SEQ_PADRAO", sequenceName = "SEQ_PADRAO", allocationSize = 1)
    @Column(name = "CD_ORIENTACAO_SEXUAL")
    private Integer cdOrientacaoSexual;

    @Column(name = "nm_orientacao", length = 50)
    private String nmOrientacao;

    @OneToMany(mappedBy = "orientacaoSexual", fetch = FetchType.LAZY)
    private List<Funcionario> funcionario;

    // Getters e Setters
    public Integer getCdOrientacaoSexual() {
        return cdOrientacaoSexual;
    }

    public void setCdOrientacaoSexual(Integer cdOrientacaoSexual) {
        this.cdOrientacaoSexual = cdOrientacaoSexual;
    }

    public String getNmOrientacao() {
        return nmOrientacao;
    }

    public void setNmOrientacao(String nmOrientacao) {
        this.nmOrientacao = nmOrientacao;
    }

    public List<Funcionario> getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(List<Funcionario> funcionario) {
        this.funcionario = funcionario;
    }
}