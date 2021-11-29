package com.lucasladeira.agendacontatos.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewContatoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String email;
	private String comentario;
	
	private String rua;
	private String numero;
	private String bairro;
	private String cep;
	
	private String telefone;
	
	private String telefone2;//opcional
	private String telefone3;//opcional
	
	private Integer cidadeId;
	
	public NewContatoDTO() {}
		
}
