package com.example.PersonalWebsite.controller;

import com.example.PersonalWebsite.model.Contacto;
import com.example.PersonalWebsite.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacto")
public class ContactoController {

    @Autowired
    private ContactoRepository contactoRepository;

    @PostMapping("/add")
    public Contacto addContacto(@RequestBody Contacto contacto){
        contacto.setDataHoraContacto(LocalDateTime.now());
        return contactoRepository.save(contacto);
    }
    @GetMapping("/all")
    public List<Contacto> getAllContactos(){
        return contactoRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Contacto> getContactoById(@PathVariable Long id){
        Optional<Contacto> contacto = contactoRepository.findById(id);
        if(contacto.isPresent()){
            return ResponseEntity.ok(contacto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/getNaoLido")
    public List<Contacto> getContactosNotLidos(){
        return contactoRepository.findLidoFalse();
    }

    @PutMapping("/markAsLido/{id}")
    public ResponseEntity<Contacto> markContactoAsLido(@PathVariable Long id){
        Optional<Contacto> contactoOpt = contactoRepository.findById(id);
        if(contactoOpt.isPresent()){
            Contacto contacto = contactoOpt.get();
            contacto.setLido(true);
            contactoRepository.save(contacto);
            return ResponseEntity.ok(contacto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContactoById(@PathVariable Long id){
        if(contactoRepository.existsById(id)){
            contactoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
