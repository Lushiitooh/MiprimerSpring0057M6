package cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @GetMapping ("/")
    public String controladorInicio (){
        return "templateIndex";
    }

}
