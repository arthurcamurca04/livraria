package br.com.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.livraria.models.Livro;
import br.com.livraria.repository.LivroRepository;

@Controller
@RequestMapping("livros")
public class LivroController {

	@Autowired
	private LivroRepository repository;

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Livro livro, RedirectAttributes attr) {
		ModelAndView mv = new ModelAndView("redirect:/");
		mv.addObject(repository.save(livro));
		attr.addFlashAttribute("sucesso", "Livro adicionado com sucesso!");
		return mv;
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		Livro livro = repository.findById(id).get();
		repository.delete(livro);
		mv.setViewName("redirect:/");
		return mv;
	}

}
