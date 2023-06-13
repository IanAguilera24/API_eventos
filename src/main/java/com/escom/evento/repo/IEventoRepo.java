package com.escom.evento.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escom.evento.model.Evento;
public interface IEventoRepo extends JpaRepository<Evento, Long> {

}
