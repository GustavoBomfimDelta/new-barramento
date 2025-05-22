package br.com.delta.barramento.controllers.handlers;

import br.com.delta.barramento.dtos.ExcecaoDTO;
import br.com.delta.barramento.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExcecaoDTO> handlerResourceNotFoundException(ResourceNotFoundException e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status.value()).body(new ExcecaoDTO(e.getMessage(), status.value()));
    }

}
