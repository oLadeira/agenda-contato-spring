package com.lucasladeira.agendacontatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasladeira.agendacontatos.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
