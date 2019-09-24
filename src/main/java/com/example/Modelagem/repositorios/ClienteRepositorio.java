package com.example.Modelagem.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Modelagem.dominio.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

}
