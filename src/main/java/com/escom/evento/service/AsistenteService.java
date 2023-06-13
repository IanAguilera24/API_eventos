package com.escom.evento.service;

import java.util.List;

import com.escom.evento.model.Asistente;

public interface AsistenteService {
	public List<Asistente> findAll();
	public Asistente create(Asistente evento);
	public Asistente update(Asistente evento);
	public Asistente findById(Long id);
	public Asistente delete(Long id);
}
