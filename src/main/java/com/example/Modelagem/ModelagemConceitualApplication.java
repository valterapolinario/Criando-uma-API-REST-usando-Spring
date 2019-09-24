package com.example.Modelagem;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Modelagem.dominio.Categoria;
import com.example.Modelagem.dominio.Produto;
import com.example.Modelagem.repositorios.CategoriaRepositorio;
import com.example.Modelagem.repositorios.ProdutoRepositorio;

@SpringBootApplication
public class ModelagemConceitualApplication implements CommandLineRunner {
	@Autowired
	CategoriaRepositorio categoriaRepositorio;
	@Autowired
	ProdutoRepositorio produtoRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(ModelagemConceitualApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "escritorio");

		Produto p1 = new Produto(null, "computador", 2000);
		Produto p2 = new Produto(null, "impressora", 800);
		Produto p3 = new Produto(null, "mouse", 80);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p1));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepositorio.saveAll(Arrays.asList(cat1, cat2));

		produtoRepositorio.saveAll(Arrays.asList(p1, p2, p3));

	}

}
