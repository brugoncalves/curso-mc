package br.com.bruna.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bruna.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
