package ir.digixo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class C01Controller1 {

    @GetMapping("/m1")
    public String m1()
    {
        return "home";
    }
    @GetMapping("/m2")
    public void m2()
    {
        //logic
       throw new NullPointerException("poch");
    }


}
