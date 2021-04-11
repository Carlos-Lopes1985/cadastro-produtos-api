package com.zup.cadastroprodutos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.cadastroprodutos.entity.Produto;
import com.zup.cadastroprodutos.repository.ProdutoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public Produto cadastrarProdutos(Produto produto) throws ObjectNotFoundException {
		
		if(produto == null) {
			 throw new ObjectNotFoundException("Produto não pode ser nulo ou vazio");
		}
		return produtoRepository.save(produto);
	}

}
