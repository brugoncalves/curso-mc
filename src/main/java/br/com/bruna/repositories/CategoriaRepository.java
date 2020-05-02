package br.com.bruna.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bruna.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
