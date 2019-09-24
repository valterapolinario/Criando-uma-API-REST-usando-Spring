package com.example.Modelagem.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Modelagem.dominio.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria,Integer> {

}
