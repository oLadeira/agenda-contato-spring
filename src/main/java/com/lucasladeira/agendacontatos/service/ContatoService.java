package com.lucasladeira.agendacontatos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasladeira.agendacontatos.domain.Contato;
import com.lucasladeira.agendacontatos.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;
	
	
	public List<Contato> findAll(){
		List<Contato> list = contatoRepository.findAll();
		return list;
	}	
	
}
