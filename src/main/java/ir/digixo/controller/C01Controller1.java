package ir.digixo.controller;

import ir.digixo.exception.ProductNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class C01Controller1 {

    @GetMapping("/m1")
    public String m1() {
        return "home";
    }

    @GetMapping("/m2")
    public void m2() {
        throw new NullPointerException("nothing!");
    }

    @GetMapping("/m3")
    public void m3() throws ProductNotFoundException {
        throw new ProductNotFoundException();
    }

//    @ExceptionHandler(NullPointerException.class)
//    public String exceptionHandler(NullPointerException ex, Model model) {
//        model.addAttribute("e", ex);
//        return "error";
//    }
}
