package com.escom.evento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escom.evento.model.Evento;
import com.escom.evento.repo.IEventoRepo;
import com.escom.evento.service.EventoService;

@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	private IEventoRepo eventoRepo;
	
	@Override
	public List<Evento> findAll() {
		return eventoRepo.findAll();
	}

	@Override
	public Evento create(Evento evento) {
		return eventoRepo.save(evento);
	}

	@Override
	public Evento findById(Long id) {
		return eventoRepo.findById(id).orElse(null);
	}

	@Override
	public Evento delete(Long id) {
		return eventoRepo.findById(id)
				.map(c -> {
					Evento e = c;
					eventoRepo.deleteById(c.getIdEvento());
					return e;
				})
				.orElse(null);
	}

	@Override
	public Evento update(Evento evento) {
		return eventoRepo.findById(evento.getIdEvento())
				.map(c -> eventoRepo.save(evento))
				.orElse(null);
				
	}

}
