package br.com.ZippyGo.Sistema_de_Diversidades.model;

import jakarta.persistence.*;

@Entity
@Table(name = "RACA_ETNIA")
public class Raca_Etnia {
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
    private Integer cd_ret;

    @Column(name = "NM_RACA_ETNIA")
    private String nm_ret;
}
