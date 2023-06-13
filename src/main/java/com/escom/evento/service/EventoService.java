package com.escom.evento.service;

import java.util.List;

import com.escom.evento.model.Evento;

public interface EventoService {
	public List<Evento> findAll();
	public Evento create(Evento evento);
	public Evento update(Evento evento);
	public Evento findById(Long id);
	public Evento delete(Long id);
}
