package br.com.ZippyGo.Sistema_de_Diversidades.dto;

import br.com.ZippyGo.Sistema_de_Diversidades.model.Iniciativa;

public record IniciativaExibicaoDTO(
        Integer cdIniciativa,
        String nmIniciativa,
        String dtIniciativa,
        String tpIniciativa
) {
    public IniciativaExibicaoDTO(Iniciativa iniciativa) {
        this(
                iniciativa.getCdIniciativa(),
                iniciativa.getNmIniciativa(),
                iniciativa.getDtIniciativa().toString(),
                iniciativa.getTpIniciativa()
        );
    }
}