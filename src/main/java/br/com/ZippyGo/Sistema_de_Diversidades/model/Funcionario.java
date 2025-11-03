package br.com.ZippyGo.Sistema_de_Diversidades.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PADRAO")
    @SequenceGenerator(name = "SEQ_PADRAO", sequenceName = "SEQ_PADRAO", allocationSize = 1)
    @Column(name = "cd_funcionario")
    private Integer cdFuncionario;  // ✅ camelCase

    @Column(name = "nm_funcionario", length = 100)
    private String nmFuncionario;  // ✅ camelCase

    @Column(name = "dt_contratacao")
    private LocalDate dtContratacao;  // ✅ camelCase

    @ManyToOne
    @JoinColumn(name = "cd_genero")
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "cd_raca_etnia")
    private RacaEtnia racaEtnia;

    @ManyToOne
    @JoinColumn(name = "cd_orientacao_sexual")
    private OrientacaoSexual orientacaoSexual;

    @Column(name = "status_funcionario", length = 10)
    private String statusFuncionario;  // ✅ camelCase

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