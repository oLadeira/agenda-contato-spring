package com.lucasladeira.agendacontatos.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucasladeira.agendacontatos.domain.Cidade;
import com.lucasladeira.agendacontatos.domain.Contato;
import com.lucasladeira.agendacontatos.domain.Endereco;
import com.lucasladeira.agendacontatos.domain.Estado;
import com.lucasladeira.agendacontatos.repository.CidadeRepository;
import com.lucasladeira.agendacontatos.repository.EstadoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Estado estado = new Estado(null, "São Paulo");		
		Cidade cidade = new Cidade(null, "São Paulo", estado);
		
		estado.getCidades().add(cidade);	
		
		estadoRepository.saveAll(Arrays.asList(estado));
		cidadeRepository.saveAll(Arrays.asList(cidade));
				
		
		Contato contato = new Contato(null, "Lucas Ladeira", "lucas@gmail.com", "Colega da Faculdade");
		
		contato.getTelefones().add("11982823311");
		
		
		Endereco endereco = new Endereco(null, "Rua tal", "322", "Bairro tal", "0221123", cidade, contato);
		
		contato.getEnderecos().add(endereco);
	}

}
