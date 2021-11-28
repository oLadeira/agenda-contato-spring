package com.lucasladeira.agendacontatos.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasladeira.agendacontatos.domain.Estado;
import com.lucasladeira.agendacontatos.service.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoResource {

	@Autowired
	private EstadoService estadoService;
	
	
	@GetMapping
	public ResponseEntity<List<Estado>> findAll(){
		List<Estado> list = estadoService.findAll();
		return ResponseEntity.ok().body(list);		
	}
	
}
