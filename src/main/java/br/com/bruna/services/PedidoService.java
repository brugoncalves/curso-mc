package br.com.bruna.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bruna.domain.Pedido;
import br.com.bruna.repositories.PedidoRepository;
import br.com.bruna.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	public Pedido findById(Long id) {
		Optional<Pedido> pedido = repository.findById(id);
		return pedido.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado! ID: " + id + ", Tipo: " 
		+ Pedido.class.getName()));
	}
	
}
