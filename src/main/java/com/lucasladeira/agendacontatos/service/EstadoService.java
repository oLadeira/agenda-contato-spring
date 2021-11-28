package com.lucasladeira.agendacontatos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lucasladeira.agendacontatos.domain.Estado;
import com.lucasladeira.agendacontatos.repository.EstadoRepository;


public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	
	public List<Estado> listAll(){
		List<Estado> list = estadoRepository.findAll();
		return list;
	}
	
}
