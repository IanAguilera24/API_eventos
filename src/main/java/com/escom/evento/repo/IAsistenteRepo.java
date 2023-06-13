package com.escom.evento.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escom.evento.model.Asistente;

public interface IAsistenteRepo extends JpaRepository<Asistente, Long> {

}
