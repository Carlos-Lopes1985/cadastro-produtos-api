package com.zup.cadastroprodutos.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zup.cadastroprodutos.entity.Produto;
import com.zup.cadastroprodutos.service.ProdutoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="api/v1/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping
	public ResponseEntity<Produto>cadastrarProduto(@RequestBody Produto produto) throws ObjectNotFoundException{
		
		return ResponseEntity.ok(produtoService.cadastrarProdutos(produto));
	}
}
