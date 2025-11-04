package br.com.ZippyGo.Sistema_de_Diversidades.dto;

import br.com.ZippyGo.Sistema_de_Diversidades.model.Funcionario;

public record FuncionarioExibicaoDTO (
        Integer cdFuncionario, String nmFuncionario, String dtContratacao, String genero, String orientacaoSexual, String racaEtnia, String status_funcionario){

        public FuncionarioExibicaoDTO(Funcionario funcionario){
            this(
                    funcionario.getCdFuncionario(),
                    funcionario.getNmFuncionario(),
                    funcionario.getDtContratacao().toString(),
                    funcionario.getGenero().getNmGenero(),
                    funcionario.getOrientacaoSexual().getNmOrientacao(),
                    funcionario.getRacaEtnia().getNmRacaEtnia(),
                    funcionario.getStatusFuncionario()
            );
        }
}
