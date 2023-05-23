package cassio.demo.resources.exceptions;

import cassio.demo.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ExceptionHandler(ResourceNotFoundException.class)
    //essa anotation diz que esse método vai interceptar
    // essa exceção e vai fazer o tratamento que tiver dentro do método
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found"; // mensagem a ser exibida
        HttpStatus status = HttpStatus.NOT_FOUND; // status que deve ser mostrado, o numero do erro
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        // Exception personalizada instanciada, com o instant do error, o status é o valor do not.found, mensagem definida pela string error
        // request.getRequestURI é o path;
        return ResponseEntity.status(status).body(err);
    }

}
