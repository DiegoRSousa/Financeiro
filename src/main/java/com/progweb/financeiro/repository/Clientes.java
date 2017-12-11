package com.progweb.financeiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progweb.financeiro.model.Cliente;

@Repository
public interface Clientes extends JpaRepository<Cliente, Long> {

	public List<Cliente> findAllByOrderByIdAsc();
}
