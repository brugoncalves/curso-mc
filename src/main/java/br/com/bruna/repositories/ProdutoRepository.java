package br.com.bruna.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bruna.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
