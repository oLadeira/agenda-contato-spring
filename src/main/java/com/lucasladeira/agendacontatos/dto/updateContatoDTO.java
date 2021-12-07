package com.lucasladeira.agendacontatos.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class updateContatoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres!")
	private String nome;
	
	@NotEmpty
	@Email(message = "E-mail inválido!")
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
	
	public updateContatoDTO() {}
	
	
	
}
