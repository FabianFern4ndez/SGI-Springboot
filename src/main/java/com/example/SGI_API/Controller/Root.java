package com.example.SGI_API.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Root {
    @GetMapping
    public String root()
    {
        return "Root de la API";
    }

    
}
