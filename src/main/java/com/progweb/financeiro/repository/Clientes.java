package com.progweb.financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.progweb.financeiro.model.Cliente;

public interface Clientes extends JpaRepository<Cliente, Long> {

}
