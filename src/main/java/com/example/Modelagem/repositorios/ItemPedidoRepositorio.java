package com.example.Modelagem.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Modelagem.dominio.Cliente;
import com.example.Modelagem.dominio.ItemPedido;

@Repository
public interface ItemPedidoRepositorio extends JpaRepository<ItemPedido, Integer> {

}
