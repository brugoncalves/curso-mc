package br.com.bruna.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bruna.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}
