package br.com.ZippyGo.Sistema_de_Diversidades.dto;

import br.com.ZippyGo.Sistema_de_Diversidades.model.Funcionario;

public record FuncionarioExibicaoDTO (
        Integer cdFuncionario, String nmFuncionario, String dtContratacao, String genero, String orientacaoSexual, String racaEtnia, String status_funcionario){

        public FuncionarioExibicaoDTO(Funcionario funcionario){
            this(
                    funcionario.getCd_funcionario(),
                    funcionario.getNm_funcionario(),
                    funcionario.getDt_contratacao().toString(),
                    funcionario.getGenero().toString(),
                    funcionario.getOrientacaoSexual().toString(),
                    funcionario.getRacaEtnia().toString(),
                    funcionario.getStatus_funcionario()
            );
        }
}
