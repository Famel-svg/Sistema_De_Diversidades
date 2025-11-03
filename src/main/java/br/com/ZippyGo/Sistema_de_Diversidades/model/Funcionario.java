package br.com.ZippyGo.Sistema_de_Diversidades.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, generator = "SEQ_PADRAO"
    )
    @SequenceGenerator(
            name = "SEQ_PADRAO", sequenceName = "SEQ_PADRAO", allocationSize = 1
    )
    private Integer cdFuncionario;

    @Column(length = 100)
    private String nmFuncionario;

    private LocalDate dtContratacao;

    @ManyToOne
    @JoinColumn(name = "cdGenero", referencedColumnName = "cd_genero")
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "cdRacaEtnia", referencedColumnName = "cd_raca_etnia")
    private RacaEtnia racaEtnia;

    @ManyToOne
    @JoinColumn(name = "cdOrientacaoSexual", referencedColumnName = "cd_orientacao_sexual")
    private OrientacaoSexual orientacaoSexual;

    @Column(length = 10)
    private String status_funcionario;

    public Integer getCd_funcionario() {
        return cdFuncionario;
    }

    public void setCd_funcionario(Integer cd_funcionario) {
        this.cdFuncionario = cd_funcionario;
    }

    public String getNm_funcionario() {
        return nmFuncionario;
    }

    public void setNm_funcionario(String nm_funcionario) {
        this.nmFuncionario = nm_funcionario;
    }

    public LocalDate getDt_contratacao() {
        return dtContratacao;
    }

    public void setDt_contratacao(LocalDate dt_contratacao) {
        this.dtContratacao = dt_contratacao;
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

    public String getStatus_funcionario() {
        return status_funcionario;
    }

    public void setStatus_funcionario(String status_funcionario) {
        this.status_funcionario = status_funcionario;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(cdFuncionario, that.cdFuncionario) && Objects.equals(nmFuncionario, that.nmFuncionario) && Objects.equals(dtContratacao, that.dtContratacao) && Objects.equals(genero, that.genero) && Objects.equals(racaEtnia, that.racaEtnia) && Objects.equals(orientacaoSexual, that.orientacaoSexual) && Objects.equals(status_funcionario, that.status_funcionario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cdFuncionario, nmFuncionario, dtContratacao, genero, racaEtnia, orientacaoSexual, status_funcionario);
    }
}