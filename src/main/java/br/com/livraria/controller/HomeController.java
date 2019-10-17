package br.com.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.livraria.models.Livro;
import br.com.livraria.repository.LivroRepository;

@Controller
public class HomeController {	

	@Autowired
	private LivroRepository repository;

	@GetMapping("/")
	private ModelAndView listarLivros(Livro livro) {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("livros", repository.findAll());
		return mv;
	}
}
