package br.com.bruna.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bruna.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
