package com.lucasladeira.agendacontatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasladeira.agendacontatos.domain.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer>{

}
