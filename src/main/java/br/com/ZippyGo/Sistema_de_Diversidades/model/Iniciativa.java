package br.com.ZippyGo.Sistema_de_Diversidades.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "INICIATIVAS")
public class Iniciativa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PADRAO")
    @SequenceGenerator(name = "SEQ_PADRAO", sequenceName = "SEQ_PADRAO", allocationSize = 1)
    @Column(name = "CD_INICIATIVA")
    private Integer cdIniciativa;

    @Column(name = "NM_INICIATIVA", length = 100)
    private String nmIniciativa;

    @Column(name = "DT_INICIATIVA")
    private LocalDate dtIniciativa;

    @Column(name = "TP_INICIATIVA", length = 50)
    private String tpIniciativa;

    public Integer getCdIniciativa() { return cdIniciativa; }
    public void setCdIniciativa(Integer cdIniciativa) { this.cdIniciativa = cdIniciativa; }

    public String getNmIniciativa() { return nmIniciativa; }
    public void setNmIniciativa(String nmIniciativa) { this.nmIniciativa = nmIniciativa; }

    public LocalDate getDtIniciativa() { return dtIniciativa; }
    public void setDtIniciativa(LocalDate dtIniciativa) { this.dtIniciativa = dtIniciativa; }

    public String getTpIniciativa() { return tpIniciativa; }
    public void setTpIniciativa(String tpIniciativa) { this.tpIniciativa = tpIniciativa; }
}