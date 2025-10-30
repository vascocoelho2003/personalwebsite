package com.example.PersonalWebsite.repository;

import com.example.PersonalWebsite.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long> {
    @Query("SELECT c FROM Contacto c WHERE c.lido = false ORDER BY c.dataHoraContacto DESC")
    List<Contacto> findLidoFalse();;
}