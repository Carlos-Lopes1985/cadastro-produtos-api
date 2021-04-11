package com.zup.cadastroprodutos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zup.cadastroprodutos.entity.Produto;
import com.zup.cadastroprodutos.repository.ProdutoRepository;

@SpringBootApplication
public class CadastroProdutosApplication implements CommandLineRunner {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CadastroProdutosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Produto prod =  Produto.builder()
				.id(null)
				.categoria("Eletronico")
				.nome("Geladeira")
				.preco(2000.)
				.qtdEstoque(100)
				.build();
		
		produtoRepository.save(prod);
	}

}
