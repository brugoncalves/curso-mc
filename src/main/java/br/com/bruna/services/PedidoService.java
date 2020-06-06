package br.com.bruna.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bruna.domain.ItemPedido;
import br.com.bruna.domain.PagamentoComBoleto;
import br.com.bruna.domain.Pedido;
import br.com.bruna.domain.enums.EstadoPagamento;
import br.com.bruna.repositories.ItemPedidoRepository;
import br.com.bruna.repositories.PagamentoRepository;
import br.com.bruna.repositories.PedidoRepository;
import br.com.bruna.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ClienteService clienteService;
	
	public Pedido findById(Long id) {
		Optional<Pedido> pedido = repository.findById(id);
		return pedido.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado! ID: " + id + ", Tipo: " 
		+ Pedido.class.getName()));
	}
	
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setData(new Date());
		obj.setCliente(clienteService.findById(obj.getCliente().getId()));
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if(obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pgto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pgto, obj.getData());
		}
		obj = repository.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		
		for(ItemPedido item : obj.getItens()) {
			item.setDesconto(0.00);
			item.setProduto(produtoService.findById(item.getProduto().getId()));
			item.setPreco(item.getProduto().getPreço());
			item.setPedido(obj);	
		}
		
		itemPedidoRepository.saveAll(obj.getItens());
		return obj;
	}
	
}
