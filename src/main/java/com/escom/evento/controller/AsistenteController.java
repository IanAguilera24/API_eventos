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

import com.escom.evento.model.Asistente;
import com.escom.evento.service.AsistenteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/asistente")
@CrossOrigin("*")
public class AsistenteController {
	
	@Autowired
	private AsistenteService asistenteService;
	
	@GetMapping
	public ResponseEntity<List<Asistente>> findAll(){
		return new ResponseEntity<>(asistenteService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Asistente> findById(@PathVariable("id") Long id){
		return new ResponseEntity<>(asistenteService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Asistente> create(@Valid @RequestBody Asistente evento){
		return new ResponseEntity<>(asistenteService.create(evento), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Asistente> update(@Valid @RequestBody Asistente evento){
		return new ResponseEntity<>(asistenteService.update(evento), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Asistente> delete(@PathVariable("id") Long id){
		return new ResponseEntity<>(asistenteService.delete(id), HttpStatus.OK);
	}

}
