package com.example.PersonalWebsite.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacto")
public class ContactoController {

    @GetMapping
    public String getContacto() {
        return "E quê?";
    }
}
