package com.example.PersonalWebsite.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String message;
    private LocalDateTime dataHoraContacto;
    private String imageUrl;

    public Contacto() {}
    public Contacto(String email, String message, LocalDateTime dataHoraContacto){
        this.email = email;
        this.message = message;
        this.dataHoraContacto = dataHoraContacto;
    }

    public long getID(){
        return this.id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }

}
