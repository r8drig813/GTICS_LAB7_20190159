package com.example.lab7_20190159.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estadisticas")
public class EstadisticasController {
    @GetMapping("/lista")
    public String index(){
        return "Estadisticas/lista";
    }
}
