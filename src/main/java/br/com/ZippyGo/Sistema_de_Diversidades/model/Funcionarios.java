package br.com.ZippyGo.Sistema_de_Diversidades.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "FUNCIONARIO")
public class Funcionarios {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PADRAO")
    @SequenceGenerator(name = "SEQ_PADRAO", sequenceName = "SEQ_PADRAO", allocationSize = 1)
    private Integer cd_funcionario;

    @Column(length = 100)
    private String nm_funcionario;

    private LocalDate dt_contratacao;

    @ManyToOne
    @JoinColumn(name = "cd_genero", referencedColumnName = "cd_genero")
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "cd_raca_etnia", referencedColumnName = "cd_raca_etnia")
    private Raca_Etnia racaEtnia;

    @ManyToOne
    @JoinColumn(name = "cd_orientacao_sexual", referencedColumnName = "cd_orientacao_sexual")
    private Orientacao_Sexual orientacaoSexual;

    @Column(length = 10)
    private String status_funcionario;

    public Integer getCd_funcionario() {
        return cd_funcionario;
    }

    public void setCd_funcionario(Integer cd_funcionario) {
        this.cd_funcionario = cd_funcionario;
    }

    public String getNm_funcionario() {
        return nm_funcionario;
    }

    public void setNm_funcionario(String nm_funcionario) {
        this.nm_funcionario = nm_funcionario;
    }

    public LocalDate getDt_contratacao() {
        return dt_contratacao;
    }

    public void setDt_contratacao(LocalDate dt_contratacao) {
        this.dt_contratacao = dt_contratacao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Raca_Etnia getRacaEtnia() {
        return racaEtnia;
    }

    public void setRacaEtnia(Raca_Etnia racaEtnia) {
        this.racaEtnia = racaEtnia;
    }

    public Orientacao_Sexual getOrientacaoSexual() {
        return orientacaoSexual;
    }

    public void setOrientacaoSexual(Orientacao_Sexual orientacaoSexual) {
        this.orientacaoSexual = orientacaoSexual;
    }

    public String getStatus_funcionario() {
        return status_funcionario;
    }

    public void setStatus_funcionario(String status_funcionario) {
        this.status_funcionario = status_funcionario;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Funcionarios that = (Funcionarios) o;
        return Objects.equals(cd_funcionario, that.cd_funcionario) && Objects.equals(nm_funcionario, that.nm_funcionario) && Objects.equals(dt_contratacao, that.dt_contratacao) && Objects.equals(genero, that.genero) && Objects.equals(racaEtnia, that.racaEtnia) && Objects.equals(orientacaoSexual, that.orientacaoSexual) && Objects.equals(status_funcionario, that.status_funcionario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cd_funcionario, nm_funcionario, dt_contratacao, genero, racaEtnia, orientacaoSexual, status_funcionario);
    }
}