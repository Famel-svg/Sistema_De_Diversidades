package br.com.ZippyGo.Sistema_de_Diversidades.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_PADRAO"
    )
    @SequenceGenerator(
            name = "SEQ_PADRAO", sequenceName = "SEQ_PADRAO",
            allocationSize = 1
    )
    @Column(name = "CD_FUNCIONARIO")
    private Integer cdFuncionario;

    @Column(name = "NM_FUNCIONARIO")
    private String nmFuncionario;

    @Column(name = "SENHA_FUNCIONARIO")
    private String senhaFuncionario;

    @Column(name = "DT_CONTRATACAO")
    private LocalDate dtContratacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CD_GENERO")
    private Genero genero;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CD_RACA_ETNIA")
    private RacaEtnia racaEtnia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CD_ORIENTACAO_SEXUAL")
    private OrientacaoSexual orientacaoSexual;

    @Column(name = "STATUS_FUNCIONARIO")
    private String statusFuncionario;

    // Getters e Setters
    public Integer getCdFuncionario() {
        return cdFuncionario;
    }

    public void setCdFuncionario(Integer cdFuncionario) {
        this.cdFuncionario = cdFuncionario;
    }

    public String getNmFuncionario() {
        return nmFuncionario;
    }

    public void setNmFuncionario(String nmFuncionario) {
        this.nmFuncionario = nmFuncionario;
    }

    public LocalDate getDtContratacao() {
        return dtContratacao;
    }

    public void setDtContratacao(LocalDate dtContratacao) {
        this.dtContratacao = dtContratacao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public RacaEtnia getRacaEtnia() {
        return racaEtnia;
    }

    public void setRacaEtnia(RacaEtnia racaEtnia) {
        this.racaEtnia = racaEtnia;
    }

    public OrientacaoSexual getOrientacaoSexual() {
        return orientacaoSexual;
    }

    public void setOrientacaoSexual(OrientacaoSexual orientacaoSexual) {
        this.orientacaoSexual = orientacaoSexual;
    }

    public String getStatusFuncionario() {
        return statusFuncionario;
    }

    public void setStatusFuncionario(String statusFuncionario) {
        this.statusFuncionario = statusFuncionario;
    }

    public String getSenhaFuncionario() {
        return senhaFuncionario;
    }

    public void setSenhaFuncionario(String senhaFuncionario) {
        this.senhaFuncionario = senhaFuncionario;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(cdFuncionario, that.cdFuncionario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cdFuncionario);
    }
}