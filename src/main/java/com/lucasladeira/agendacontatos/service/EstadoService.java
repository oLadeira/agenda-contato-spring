package com.lucasladeira.agendacontatos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasladeira.agendacontatos.domain.Estado;
import com.lucasladeira.agendacontatos.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	
	public List<Estado> findAll(){
		List<Estado> list = estadoRepository.findAll();
		return list;
	}
	
}
