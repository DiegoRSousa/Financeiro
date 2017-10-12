package com.progweb.financeiro.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.progweb.financeiro.model.Cliente;
import com.progweb.financeiro.repository.Clientes;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private Clientes clientes;

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("Clientes");
		modelAndView.addObject("clientes", clientes.findAll());
		modelAndView.addObject(new Cliente());
		return modelAndView;
	}
	
	@PostMapping 
	public ModelAndView salvar(@Validated Cliente clinete, Errors errors, RedirectAttributes attributes) {
		if(errors.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("Clientes");
			modelAndView.addObject("clientes", clientes.findAll());
			return modelAndView;
		}
				
		this.clientes.save(clinete);
		attributes.addFlashAttribute("mensagem", "Cliente salvo com sucesso!");
		return new ModelAndView("redirect:/clientes");
	}
}
