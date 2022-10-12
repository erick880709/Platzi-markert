package com.platzi.markert.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Saludar")
public class HolaMundoController {

    @GetMapping("/Hola")
    public String Saludar(){
        return ("Hola mundo es mi primer programa");
    }
}
