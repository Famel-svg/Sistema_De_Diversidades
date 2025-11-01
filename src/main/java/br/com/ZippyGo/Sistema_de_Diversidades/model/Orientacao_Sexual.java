package br.com.ZippyGo.Sistema_de_Diversidades.model;

import jakarta.persistence.*;

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
    private Integer cd_osx;

    @Column(name = "nm_orientacao")
    private String nm_osx;
}
