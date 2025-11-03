package br.com.ZippyGo.Sistema_de_Diversidades.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "GENERO")
public class Genero {

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
    private Integer cdGenero;

    @Column(name = "NM_GENERO", length = 50)
    private String nmGenero;

    @OneToMany(mappedBy = "cd_genero", fetch = FetchType.LAZY)
    private List<Funcionario> funcionarios;

}
