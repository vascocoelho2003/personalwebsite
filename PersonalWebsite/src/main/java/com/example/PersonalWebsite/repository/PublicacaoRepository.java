package com.example.PersonalWebsite.repository;

import com.example.PersonalWebsite.model.Publicacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {
    @Query("SELECT p FROM Publicacao p  ORDER BY p.dataHoraPublicacao DESC")
    List<Publicacao> findPublicacoes();;
}
