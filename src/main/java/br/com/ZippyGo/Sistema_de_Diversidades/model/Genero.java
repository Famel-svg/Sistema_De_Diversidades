package br.com.ZippyGo.Sistema_de_Diversidades.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "GENERO")
public class Genero {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, generator = "SEQ_PADRAO"
    )
    @SequenceGenerator(
            name = "SEQ_PADRAO",
            sequenceName = "SEQ_PADRAO",
            allocationSize = 1
    )
    @Column(name = "CD_GENERO")
    private Integer cdGenero;

    @Column(name = "NM_GENERO", length = 10)
    private String nmGenero;

    @OneToMany(mappedBy = "genero", fetch = FetchType.LAZY)
    private List<Funcionario> funcionario;

    // Getters e Setters
    public Integer getCdGenero() {
        return cdGenero;
    }

    public void setCdGenero(Integer cdGenero) {
        this.cdGenero = cdGenero;
    }

    public String getNmGenero() {
        return nmGenero;
    }

    public void setNmGenero(String nmGenero) {
        this.nmGenero = nmGenero;
    }

    public List<Funcionario> getFuncionario() {
        return funcionario;
    }

    public void setFuncionarios(List<Funcionario> funcionario) {
        this.funcionario = funcionario;
    }
}