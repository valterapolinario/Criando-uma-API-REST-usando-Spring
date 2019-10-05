package com.example.Modelagem.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Modelagem.dominio.Estado;
import com.example.Modelagem.dominio.Pagamento;

@Repository
public interface PagamentoRepositorio extends JpaRepository<Pagamento, Integer> {

}
