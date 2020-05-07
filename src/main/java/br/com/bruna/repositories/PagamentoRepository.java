package br.com.bruna.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bruna.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{

}
