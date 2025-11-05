package br.com.ZippyGo.Sistema_de_Diversidades.dto;

import jakarta.validation.constraints.NotBlank;


public record FuncionarioCadastroDTO(
        Integer cdFuncionario,

        @NotBlank(message = "Nome do funcionario é obrigatorio!")
        String nmFuncionario,

        @NotBlank(message = "Senha é obrigatório!")
        String senhaFuncionario,

        @NotBlank(message = "Data da contratação do funcionario é obrigatorio!")
        String dtContratacao,

        @NotBlank(message = "Genero do funcionario é obrigatorio!")
        String genero,

        @NotBlank(message = "Orientação sexual do funcionario é obrigatorio!")
        String orientacaoSexual,

        @NotBlank(message = "Etnia do funcionario é obrigatorio!")
        String racaEtnia,

        @NotBlank(message = "Status do funcionario é obrigatorio!")
        String status_funcionario
){
        public String getsenhaFuncionario() {
                return senhaFuncionario;
        }
}
