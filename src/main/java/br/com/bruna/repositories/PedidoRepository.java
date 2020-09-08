package br.com.bruna.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bruna.domain.Cliente;
import br.com.bruna.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	@Transactional(readOnly = true)
	Page<Pedido> findByCliente(Cliente cliente, Pageable pageRequest);
}
