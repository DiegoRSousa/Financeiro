package com.progweb.financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.progweb.financeiro.model.Recebimento;

public interface Recebimentos extends JpaRepository<Recebimento, Long> {

}
