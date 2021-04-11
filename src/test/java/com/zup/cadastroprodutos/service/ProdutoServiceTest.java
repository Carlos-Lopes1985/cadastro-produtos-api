package com.zup.cadastroprodutos.service;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.zup.cadastroprodutos.entity.Produto;
import com.zup.cadastroprodutos.repository.ProdutoRepository;

import javassist.tools.rmi.ObjectNotFoundException;


@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {
	
	@InjectMocks
	private ProdutoServiceImpl produtoServiceImpl;
	
	@Mock
	private ProdutoRepository produtoRepository;
	
	private Produto prod;
	
	@BeforeEach
	public void setup() {
		
		prod =  Produto.builder()
				.id(null)
				.categoria("Eletronico")
				.nome("Geladeira")
				.preco(2000.)
				.qtdEstoque(100)
				.build();
	}
	
	@Test
	public void givenRegisterProduct_when_sucess() throws ObjectNotFoundException {
		Mockito.when(produtoRepository.save(Mockito.any())).thenReturn(prod);
		Produto produto = produtoServiceImpl.cadastrarProdutos(prod);
		
		Assert.assertNotNull(produto);
	}
	
	@Test
	public void givenRegisterProduct_when_thenReturn_Exception() throws ObjectNotFoundException {
		
		Exception exception = assertThrows(ObjectNotFoundException.class, () -> {
			produtoServiceImpl.cadastrarProdutos(null);
		    });
		
		String expectedMessage = "Produto não pode ser nulo ou vazio";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
}
