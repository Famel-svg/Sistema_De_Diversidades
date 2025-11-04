package br.com.ZippyGo.Sistema_de_Diversidades.advice;

import br.com.ZippyGo.Sistema_de_Diversidades.exceptions.ListaVaziaException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(ListaVaziaException.class )
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleListaVaziaException(ListaVaziaException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("erro", ex.getMessage());
        errorMap.put("status", HttpStatus.NOT_FOUND.toString());
        return errorMap;
    }
}
