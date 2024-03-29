package br.com.bruna.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruna.domain.Produto;
import br.com.bruna.domain.dto.ProdutoDTO;
import br.com.bruna.resources.utils.URL;
import br.com.bruna.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		Produto produto = produtoService.findById(id);
		return ResponseEntity.ok().body(produto);
	}
	
	@GetMapping
	public ResponseEntity<Page<ProdutoDTO>> findByPage(
			@RequestParam(value = "nome", defaultValue = "") String nome,
			@RequestParam(value = "categorias", defaultValue = "") String categorias,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction){
				String nomeDecoded = URL.decodeParam(nome);
				List<Long> ids = URL.decodeLong(categorias);
				Page<Produto> produtos = produtoService.search(nomeDecoded, ids, page, linesPerPage, direction, orderBy);
				Page<ProdutoDTO> listDto = produtos.map(obj -> new ProdutoDTO(obj));
				return ResponseEntity.ok().body(listDto);
				
				
	}
}
