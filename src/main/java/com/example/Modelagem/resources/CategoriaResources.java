package com.example.Modelagem.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Modelagem.dominio.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {
	@RequestMapping(method = RequestMethod.GET)
	public List listar() {

		Categoria cat1 = new Categoria(1, "informatica");
		Categoria cat2 = new Categoria(2, "escritorio");

		List<Categoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);

		return lista;
	}

}
