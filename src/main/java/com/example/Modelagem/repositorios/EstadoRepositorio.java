package com.example.Modelagem.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Modelagem.dominio.Estado;

@Repository
public interface EstadoRepositorio extends JpaRepository<Estado, Integer> {

}
