package br.com.bruna.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bruna.domain.Categoria;
import br.com.bruna.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria findById(Long id) {
		Optional<Categoria> categoria = repository.findById(id);
		return categoria.orElse(null);
	}
}
