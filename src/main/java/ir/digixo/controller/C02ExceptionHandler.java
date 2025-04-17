package ir.digixo.controller;

import ir.digixo.exception.MyErrorResponse;
import ir.digixo.exception.ProductNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
@RequestMapping("/")
public class C02ExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public String exceptionHandler(NullPointerException ex, Model model) {
        model.addAttribute("e", ex);
        return "error";
    }

    @ExceptionHandler({ProductNotFoundException.class})
    public ResponseEntity<MyErrorResponse> productNotFoundException(ProductNotFoundException ex) {
        MyErrorResponse myErrorResponse = new MyErrorResponse(403, "ProductNotFondException Message");
        return ResponseEntity.status(403).contentType(MediaType.APPLICATION_JSON).body(myErrorResponse);
    }

    @ExceptionHandler({NoHandlerFoundException.class})
    public ResponseEntity<MyErrorResponse> handlerNotFoundException(NoHandlerFoundException ex) {
        MyErrorResponse myErrorResponse = new MyErrorResponse(404, "Resource Not Found");
        return ResponseEntity.status(404).contentType(MediaType.APPLICATION_JSON).body(myErrorResponse);
    }

}
