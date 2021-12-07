package com.lucasladeira.agendacontatos.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucasladeira.agendacontatos.domain.Contato;
import com.lucasladeira.agendacontatos.dto.ContatoDTO;
import com.lucasladeira.agendacontatos.dto.NewContatoDTO;
import com.lucasladeira.agendacontatos.dto.updateContatoDTO;
import com.lucasladeira.agendacontatos.service.ContatoService;
import com.lucasladeira.agendacontatos.service.EnderecoService;

@RestController
@RequestMapping("/contatos")
public class ContatoResource {

	@Autowired
	private ContatoService contatoService;
	

	
	@GetMapping
	public ResponseEntity<List<ContatoDTO>> findAllDTO(){
		List<ContatoDTO> list = contatoService.findAllDTO();
		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping("/pesquisarId")
	public ResponseEntity<Optional<Contato>> findById(@RequestParam(name = "id") Integer id){
		Optional<Contato> opt = contatoService.findById(id);
		return ResponseEntity.ok().body(opt);
	}
	
	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody NewContatoDTO newContatoDTO){
		Contato contato = contatoService.fromDTO(newContatoDTO);
		contatoService.save(contato);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(contato.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
//	@PutMapping("/editar")
//	public ResponseEntity<Void> update(@RequestParam(name = "id") Integer id, @RequestBody updateContatoDTO updateContatoDTO){
//		Contato contato = contatoService.from
//		return ResponseEntity.ok().build();
//	}
	
	@DeleteMapping("/deletar")
	public ResponseEntity<Void> delete(@RequestParam(name = "id") Integer id){
		contatoService.delete(id);
		return ResponseEntity.ok().build();
	}
}
