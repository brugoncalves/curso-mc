package br.com.bruna.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bruna.domain.Cliente;
import br.com.bruna.repositories.ClienteRepository;
import br.com.bruna.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public Cliente findById(Long id) {
		Optional<Cliente> cliente = repository.findById(id);
		return cliente.orElseThrow( () -> new ObjectNotFoundException(
				"Objeto não encontrado. ID: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
}
