package br.com.ZippyGo.Sistema_de_Diversidades.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND ) // Retorna 404 Not Found
public class ListaVaziaException extends RuntimeException {

    public ListaVaziaException(String recurso) {
        super("Nenhum registro encontrado para o recurso: " + recurso);
    }
}
