package com.zup.cadastroprodutos.service;

import com.zup.cadastroprodutos.entity.Produto;

import javassist.tools.rmi.ObjectNotFoundException;

public interface ProdutoService {
	
	Produto cadastrarProdutos(Produto produto) throws ObjectNotFoundException;
}
