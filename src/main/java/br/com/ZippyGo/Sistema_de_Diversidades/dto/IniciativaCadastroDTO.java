package br.com.ZippyGo.Sistema_de_Diversidades.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record IniciativaCadastroDTO(
        @NotBlank(message = "Nome da iniciativa é obrigatório!")
        String nmIniciativa,

        @NotNull(message = "Data da iniciativa é obrigatória!")
        LocalDate dtIniciativa,

        @NotBlank(message = "Tipo da iniciativa é obrigatório!")
        String tpIniciativa
) {
}