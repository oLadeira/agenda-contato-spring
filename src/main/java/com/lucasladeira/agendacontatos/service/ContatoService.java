package com.lucasladeira.agendacontatos.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.lucasladeira.agendacontatos.domain.Cidade;
import com.lucasladeira.agendacontatos.domain.Contato;
import com.lucasladeira.agendacontatos.domain.Endereco;
import com.lucasladeira.agendacontatos.dto.ContatoDTO;
import com.lucasladeira.agendacontatos.dto.NewContatoDTO;
import com.lucasladeira.agendacontatos.repository.ContatoRepository;
import com.lucasladeira.agendacontatos.repository.EnderecoRepository;
import com.lucasladeira.agendacontatos.service.exceptions.ObjectNotFoundException;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Contato> findAll(){
		List<Contato> list = contatoRepository.findAll();
		return list;
	}
	
	@Transactional
	public void save (Contato contato) {
		contato.setId(null);
		contatoRepository.save(contato);
		enderecoRepository.saveAll(contato.getEnderecos());
	}
	
	public Contato update (Integer id, Contato oldContato) {
		Optional<Contato> opt = contatoRepository.findById(id);
		
		if (opt.isEmpty()){
			throw new ObjectNotFoundException("Contato não encontrado!");
		}
		
		Contato databaseContato = opt.get();
		
		updateData(databaseContato, oldContato);
	
		return contatoRepository.save(databaseContato);	
	}
	
	public void delete (Integer id) {
		Optional<Contato> opt = contatoRepository.findById(id);
		
		if (opt.isEmpty()) {
			throw new ObjectNotFoundException("Contato não encontrado!");
		}
		
		try {
			contatoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não foi possível deletar o contato, há objetos relacionados");
		}		
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
	
	public Contato fromDTO (NewContatoDTO newContatoDTO) {
		Contato contato = new Contato(null, newContatoDTO.getNome(), newContatoDTO.getEmail(), newContatoDTO.getComentario());
		Cidade cidade = new Cidade(newContatoDTO.getCidadeId(), null, null);
		Endereco endereco = new Endereco(null, newContatoDTO.getRua(), newContatoDTO.getNumero(), newContatoDTO.getBairro(), newContatoDTO.getCep(), cidade, contato);
		
		contato.getEnderecos().add(endereco);
		
		contato.getTelefones().add(newContatoDTO.getTelefone());
		
		if (newContatoDTO.getTelefone2() != null) {
			contato.getTelefones().add(newContatoDTO.getTelefone2());
		}
		
		if (newContatoDTO.getTelefone3() != null) {
			contato.getTelefones().add(newContatoDTO.getTelefone3());
		}
		return contato;
	}
}
