package com.williamartins.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.williamartins.cursomc.domain.Categoria;
import com.williamartins.cursomc.domain.Produto;
import com.williamartins.cursomc.repositories.CategoriaRepository;
import com.williamartins.cursomc.repositories.ProdutoRepository;

/*Classe prncipal para executar o projeto.*/
@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	/*metodo auxiliar que permiti executar alguma ação quando a aplicação é iniciada
	 * implements CommandLineRunner  
	 * inserindo categorias no banco de dados.*/
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto (null, "Computador", 2000.00);
		Produto p2 = new Produto (null, "Impressora", 800.00);
		Produto p3 = new Produto (null, "Mouse", 80.00);
		Produto p4 = new Produto (null, "Teclado", 10.00);
		Produto p5 = new Produto (null, "Tela", 150.00);
		Produto p6 = new Produto (null, "Mesa", 250.00);
		
		/*Separando cada produto por suas categorias.*/
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
		cat2.getProdutos().addAll(Arrays.asList(p2, p6));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat1));
		p5.getCategorias().addAll(Arrays.asList(cat1));
		p6.getCategorias().addAll(Arrays.asList(cat1,cat2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));	
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
	}
}
