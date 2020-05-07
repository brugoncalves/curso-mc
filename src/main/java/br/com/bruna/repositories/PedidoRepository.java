package br.com.bruna.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bruna.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
