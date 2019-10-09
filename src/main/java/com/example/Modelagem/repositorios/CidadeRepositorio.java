package com.example.Modelagem.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Modelagem.dominio.Cidade;

@Repository
public interface CidadeRepositorio extends JpaRepository<Cidade, Integer> {

	

}
