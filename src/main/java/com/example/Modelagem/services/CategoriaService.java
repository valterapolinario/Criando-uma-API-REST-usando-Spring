package com.example.Modelagem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Modelagem.dominio.Categoria;
import com.example.Modelagem.repositorios.CategoriaRepositorio;
import com.example.Modelagem.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepositorio repo;

	public List<Categoria> findAll() {
		return repo.findAll();
	}

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));

	}
}
