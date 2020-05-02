package br.com.bruna.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruna.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@GetMapping
	public List<Categoria> listar() {
		
		Categoria cat = new Categoria(1, "Informática");
		Categoria cat1 = new Categoria(2, "Livros");
		Categoria cat2 = new Categoria (3, "Cama, Mesa e Banho");
		
		List<Categoria> list = new ArrayList<>();
		list.add(cat);
		list.add(cat1);
		list.add(cat2);
		
		return list;
	}
}
