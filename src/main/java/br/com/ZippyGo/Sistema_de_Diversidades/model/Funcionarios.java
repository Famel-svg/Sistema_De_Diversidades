package br.com.ZippyGo.Sistema_de_Diversidades.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "FUNCIONARIO")
public class Funcionarios {

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

    private String cd_funcionario;

    private String nm_funcionario;
    private LocalDate dt_funcionario;
    private Integer cd_genero;

    @Column(name = "cd_raca_etnia")
    private Integer cd_ret;

    @Column(name = "cd_estado_civil")
    private Integer cd_osx;

    private String status_funcionario;

    public String getCd_funcionario() {
        return cd_funcionario;
    }

    public void setCd_funcionario(String cd_funcionario) {
        this.cd_funcionario = cd_funcionario;
    }

    public String getNm_funcionario() {
        return nm_funcionario;
    }

    public void setNm_funcionario(String nm_funcionario) {
        this.nm_funcionario = nm_funcionario;
    }

    public LocalDate getDt_funcionario() {
        return dt_funcionario;
    }

    public void setDt_funcionario(LocalDate dt_funcionario) {
        this.dt_funcionario = dt_funcionario;
    }

    public Integer getCd_genero() {
        return cd_genero;
    }

    public void setCd_genero(Integer cd_genero) {
        this.cd_genero = cd_genero;
    }

    public Integer getCd_ret() {
        return cd_ret;
    }

    public void setCd_ret(Integer cd_ret) {
        this.cd_ret = cd_ret;
    }

    public Integer getCd_osx() {
        return cd_osx;
    }

    public void setCd_osx(Integer cd_osx) {
        this.cd_osx = cd_osx;
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
        return Objects.equals(cd_funcionario, that.cd_funcionario) && Objects.equals(nm_funcionario, that.nm_funcionario) && Objects.equals(dt_funcionario, that.dt_funcionario) && Objects.equals(cd_genero, that.cd_genero) && Objects.equals(cd_ret, that.cd_ret) && Objects.equals(cd_osx, that.cd_osx) && Objects.equals(status_funcionario, that.status_funcionario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cd_funcionario, nm_funcionario, dt_funcionario, cd_genero, cd_ret, cd_osx, status_funcionario);
    }
}
