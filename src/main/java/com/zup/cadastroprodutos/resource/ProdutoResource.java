package com.zup.cadastroprodutos.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zup.cadastroprodutos.entity.Produto;
import com.zup.cadastroprodutos.service.ProdutoService;
import com.zup.cadastroprodutos.util.Constants;
import com.zup.cadastroprodutos.validation.SchemaValidator;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="api/v1/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private SchemaValidator schemaValidator;
	
	@PostMapping
	public ResponseEntity<Produto>cadastrarProduto(@RequestBody Produto produto) throws ObjectNotFoundException{
		
		schemaValidator.validate(Constants.PRODUCT_API_REQUEST_JSONSCHEMA, produto);
		
		return ResponseEntity.ok(produtoService.cadastrarProdutos(produto));
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>>listarTodosProdutos(){
		return ResponseEntity.ok(produtoService.buscarTodosProdutos());
	}
}
