package com.lucasladeira.agendacontatos.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasladeira.agendacontatos.domain.Contato;
import com.lucasladeira.agendacontatos.dto.ContatoDTO;
import com.lucasladeira.agendacontatos.service.ContatoService;

@RestController
@RequestMapping("/contatos")
public class ContatoResource {

	@Autowired
	private ContatoService contatoService;
	
	@GetMapping
	public ResponseEntity<List<Contato>> findAll(){
		List<Contato> list = contatoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id,@RequestBody ContatoDTO contatoDTO){
		Contato contato = contatoService.fromDTO(contatoDTO);
		contato = contatoService.update(id, contato);
		return ResponseEntity.ok().build();
	}
	
}
