package com.progweb.financeiro.model;

public enum StatusRecebimento {

	Pendente("Pendente"),
	Recebido("Recebido");
	
	private String descricao;
	
	private StatusRecebimento(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
