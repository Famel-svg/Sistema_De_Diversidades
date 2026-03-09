package br.com.ZippyGo.Sistema_de_Diversidades.advice;

import br.com.ZippyGo.Sistema_de_Diversidades.exceptions.ListaVaziaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
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

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleBadRequestException(HttpMessageNotReadableException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("erro", "Corpo da requisição ausente ou inválido: " + ex.getMessage());
        errorMap.put("status", HttpStatus.BAD_REQUEST.toString());
        return errorMap;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Map<String, String> handleRuntimeException(RuntimeException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("erro", ex.getMessage());
        errorMap.put("status", HttpStatus.UNAUTHORIZED.toString());
        return errorMap;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handleGeneralException(Exception ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("erro", "Ocorreu um erro inesperado: " + ex.getMessage());
        errorMap.put("status", HttpStatus.INTERNAL_SERVER_ERROR.toString());
        return errorMap;
    }
}
