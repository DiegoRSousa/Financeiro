package com.progweb.financeiro.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.progweb.financeiro.model.Recebimento;
import com.progweb.financeiro.model.StatusRecebimento;
import com.progweb.financeiro.repository.Clientes;
import com.progweb.financeiro.repository.Recebimentos;

@Controller
@RequestMapping("/recebimentos")
public class RecebimentoController {

	@Autowired
	private Recebimentos recebimentos;
	
	@Autowired
	private Clientes clientes;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("Recebimentos");
		modelAndView.addObject("recebimentos", recebimentos.findAll());
		modelAndView.addObject(new Recebimento());
		modelAndView.addObject("clientes", clientes.findAll());
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(Recebimento recebimento) {
		this.recebimentos.save(recebimento);
		return "redirect:/recebimentos";
	}
	
	@ModelAttribute("todosStatus")
	public List<StatusRecebimento> todosStatus() {
		return Arrays.asList(StatusRecebimento.values());
	}
}