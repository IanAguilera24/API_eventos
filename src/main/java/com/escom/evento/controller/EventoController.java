package com.escom.evento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escom.evento.model.Evento;
import com.escom.evento.service.EventoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/evento")
@CrossOrigin("*")
public class EventoController {

	@Autowired
	private EventoService eventoService;
	
	@GetMapping
	public ResponseEntity<List<Evento>> findAll(){
		return new ResponseEntity<>(eventoService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Evento> findById(@PathVariable("id") Long id){
		return new ResponseEntity<>(eventoService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Evento> create(@Valid @RequestBody Evento evento){
		return new ResponseEntity<>(eventoService.create(evento), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Evento> update(@Valid @RequestBody Evento evento){
		return new ResponseEntity<>(eventoService.update(evento), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Evento> delete(@PathVariable("id") Long id){
		return new ResponseEntity<>(eventoService.delete(id), HttpStatus.OK);
	}
	
}
