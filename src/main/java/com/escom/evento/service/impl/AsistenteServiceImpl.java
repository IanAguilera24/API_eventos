package com.escom.evento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escom.evento.model.Asistente;
import com.escom.evento.repo.IAsistenteRepo;
import com.escom.evento.service.AsistenteService;

@Service
public class AsistenteServiceImpl implements AsistenteService {

	@Autowired
	private IAsistenteRepo asistenteRepo;
	
	@Override
	public List<Asistente> findAll() {
		return asistenteRepo.findAll();
	}

	@Override
	public Asistente create(Asistente evento) {
		return asistenteRepo.save(evento);
	}

	@Override
	public Asistente findById(Long id) {
		return asistenteRepo.findById(id).orElse(null);
	}

	@Override
	public Asistente delete(Long id) {
		return asistenteRepo.findById(id)
				.map(c -> {
					Asistente e = c;
					asistenteRepo.deleteById(c.getIdAsistente());
					return e;
				})
				.orElse(null);
	}

	@Override
	public Asistente update(Asistente evento) {
		return asistenteRepo.findById(evento.getIdAsistente())
				.map(c -> asistenteRepo.save(evento))
				.orElse(null);
				
	}

}
