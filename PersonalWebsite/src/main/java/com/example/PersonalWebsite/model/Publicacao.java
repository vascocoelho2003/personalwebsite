package com.example.PersonalWebsite.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Publicacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String conteudo;
    private LocalDateTime dataHoraPublicacao;

    public Publicacao() {}
    public Publicacao(String titulo, String conteudo, LocalDateTime dataHoraPublicacao) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.dataHoraPublicacao = dataHoraPublicacao;
    }

    public Long getId() {
        return id;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    public String getConteudo() {
        return conteudo;
    }

}
