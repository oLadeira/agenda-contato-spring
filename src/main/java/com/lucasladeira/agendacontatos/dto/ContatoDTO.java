package com.lucasladeira.agendacontatos.dto;

import java.io.Serializable;

import com.lucasladeira.agendacontatos.domain.Contato;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContatoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String nome;
	private String email;
	private String comentario;
	
	public ContatoDTO() {}
	
	public ContatoDTO(Contato contato) {
		this.id = contato.getId();
		this.nome = contato.getNome();
		this.email = contato.getEmail();
		this.comentario = contato.getComentario();
	}
}
