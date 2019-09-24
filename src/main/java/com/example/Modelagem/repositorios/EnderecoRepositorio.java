package com.example.Modelagem.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Modelagem.dominio.Endereco;

@Repository
public interface EnderecoRepositorio extends JpaRepository<Endereco, Integer> {

}
