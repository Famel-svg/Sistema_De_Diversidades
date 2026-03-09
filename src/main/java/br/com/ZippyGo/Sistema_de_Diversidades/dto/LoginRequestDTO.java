package br.com.ZippyGo.Sistema_de_Diversidades.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequestDTO {
    @JsonProperty("nomeFuncionario")
    private String nomeFuncionario;
    @JsonProperty("senhaFuncionario")
    private String senhaFuncionario;

    public LoginRequestDTO() {}

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getSenhaFuncionario() {
        return senhaFuncionario;
    }

    public void setSenhaFuncionario(String senhaFuncionario) {
        this.senhaFuncionario = senhaFuncionario;
    }
}
