package mycom.error;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    public ProblemDetail handleError(RuntimeException rx, HttpServletRequest request){
        var pd= ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pd.setProperty("timestamp", LocalDate.now());
        pd.setProperty("error msg", rx.getMessage()
        
        );
        return pd;
    }

    
}
