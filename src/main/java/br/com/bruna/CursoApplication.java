package br.com.bruna;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.bruna.domain.Categoria;
import br.com.bruna.domain.Cidade;
import br.com.bruna.domain.Cliente;
import br.com.bruna.domain.Endereco;
import br.com.bruna.domain.Estado;
import br.com.bruna.domain.Produto;
import br.com.bruna.domain.enums.TipoCliente;
import br.com.bruna.repositories.CategoriaRepository;
import br.com.bruna.repositories.CidadeRepository;
import br.com.bruna.repositories.ClienteRepository;
import br.com.bruna.repositories.EnderecoRepository;
import br.com.bruna.repositories.EstadoRepository;
import br.com.bruna.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.0);
		Produto p2 = new Produto(null, "Mouse", 35.00);
		Produto p3 = new Produto(null, "Impressora", 800.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat2));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null, "Campinas", est2);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Uberlândia", est1);
		
		est1.getCidades().addAll(Arrays.asList(cid3));
		est2.getCidades().addAll(Arrays.asList(cid1, cid2));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		
		Cliente cli1 = new Cliente(null, "Maria Brown","maria@gmail.com", "11122233344", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("32326587", "32321498"));
		
		Endereco end1 = new Endereco(null, "Rua Liberdade", "2020", null, "Centro", "15000320", cli1, cid1);
		Endereco end2 = new Endereco(null, "Avenida Paulista", "5000", "Ap 23", "Bela Vista", "25000000", cli1, cid2);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
		
		
		
		
		
		
	}

}
