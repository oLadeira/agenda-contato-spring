package com.lucasladeira.agendacontatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasladeira.agendacontatos.domain.Contato;
import com.lucasladeira.agendacontatos.dto.ContatoDTO;
import com.lucasladeira.agendacontatos.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;
	
	
	public List<Contato> findAll(){
		List<Contato> list = contatoRepository.findAll();
		return list;
	}
	
	
	public void save (Contato contato) {
		contatoRepository.save(contato);
	}
	
	public Contato update (Integer id, Contato oldContato) {
		Optional<Contato> opt = contatoRepository.findById(id);
		
		if (opt.isEmpty()){
			System.out.println("erro");
		}
		
		Contato databaseContato = opt.get();
		
		updateData(databaseContato, oldContato);
	
		return contatoRepository.save(databaseContato);	
	}
	
	
	//----------------auxiliares----------------------
	private void updateData(Contato databaseContato, Contato contato) {
		databaseContato.setNome(contato.getNome());
		databaseContato.setEmail(contato.getEmail());
		databaseContato.setComentario(contato.getComentario());
	}
	
	public Contato fromDTO (ContatoDTO contatoDTO) {
		return new Contato(contatoDTO.getId(), contatoDTO.getNome(), contatoDTO.getEmail(), contatoDTO.getComentario());
	}
	
}
