package br.com.lets.api.controller.exceptions;


import br.com.lets.api.services.exceptions.DadosMessageException;
import br.com.lets.api.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<DtoErro> notFound(ObjectNotFoundException elem, HttpServletRequest request){
        DtoErro erro = new DtoErro(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), elem.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
    @ExceptionHandler(DadosMessageException.class)
    public ResponseEntity<DtoErro> dadosException(DadosMessageException elem, HttpServletRequest request){
        DtoErro erro = new DtoErro(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), elem.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}
