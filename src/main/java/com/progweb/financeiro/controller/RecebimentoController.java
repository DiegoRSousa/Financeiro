package com.progweb.financeiro.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public ModelAndView salvar(@Validated Recebimento recebimento, Errors errors, RedirectAttributes attributes) {
		if(errors.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("Recebimentos");
			modelAndView.addObject("recebimentos", recebimentos.findAll());
			modelAndView.addObject("clientes", clientes.findAll());
			return modelAndView;
		}

		this.recebimentos.save(recebimento);
		attributes.addFlashAttribute("mensagem", "Recebimento salvo com sucesso!");
		return new ModelAndView("redirect:/recebimentos");
	}
	
	
	@ModelAttribute("todosStatus")
	public List<StatusRecebimento> todosStatus() {
		return Arrays.asList(StatusRecebimento.values());
	}
}