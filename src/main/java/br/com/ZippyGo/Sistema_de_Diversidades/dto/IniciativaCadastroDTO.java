package br.com.ZippyGo.Sistema_de_Diversidades.dto;

import jakarta.validation.constraints.NotBlank;

public record IniciativaCadastroDTO(
        @NotBlank(message = "O nome da iniciativa é obrigatório!")
        String nmIniciativa,

        @NotBlank(message = "A data da iniciativa é obrigatória!")
        String dtIniciativa,

        @NotBlank(message = "O tipo da iniciativa é obrigatório!")
        String tpIniciativa
) {}
