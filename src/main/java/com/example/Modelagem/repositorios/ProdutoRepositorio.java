package com.example.Modelagem.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Modelagem.dominio.Categoria;
import com.example.Modelagem.dominio.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto,Integer> {

}
