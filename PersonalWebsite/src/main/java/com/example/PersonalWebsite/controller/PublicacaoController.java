package com.example.PersonalWebsite.controller;

import com.example.PersonalWebsite.model.Publicacao;
import com.example.PersonalWebsite.repository.PublicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/publicacao")
public class PublicacaoController {

    @Autowired
    private PublicacaoRepository publicacaoRepository;

    @PostMapping("/add")
    public void addPublicacao(@RequestBody Publicacao publicacao){
        publicacao.setDataHoraPublicacao(LocalDateTime.now());
        publicacaoRepository.save(publicacao);
    }
    @GetMapping("/all")
    public List<Publicacao> getAllPublicacoes(){
        return publicacaoRepository.findAll();
    }
    @PutMapping("/update/{id}")
    public void updatePublicacao(@RequestBody Publicacao publicacao,@PathVariable Long id){
        Publicacao existingPublicacao = publicacaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Publicacao not found"));
        existingPublicacao.setTitulo(publicacao.getTitulo());
        existingPublicacao.setConteudo(publicacao.getConteudo());
        existingPublicacao.setDataHoraPublicacao(publicacao.getDataHoraPublicacao());
        publicacaoRepository.save(existingPublicacao);
    }
    @GetMapping("/{id}")
    public Publicacao getPublicacaoById(@PathVariable Long id){
        return publicacaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Publicacao not found"));
    }
    @DeleteMapping("/{id}")
    public void deletePublicacaoById(@PathVariable Long id){
        publicacaoRepository.deleteById(id);
    }
}
