package br.com.ZippyGo.Sistema_de_Diversidades.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ORIENTACAO_SEXUAL")
public class Orientacao_Sexual {

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
    private List<Funcionarios> funcionarios;
}
