package com.elcarvalho.apirest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcarvalho.apirest.domain.Pedido;
import com.elcarvalho.apirest.exceptions.ObjectNotFoundException;
import com.elcarvalho.apirest.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;

	
	public Pedido buscar(Integer id) {
		
		Optional<Pedido> pedido = repo.findById(id);
		
		return pedido.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
