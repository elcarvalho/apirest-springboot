package com.elcarvalho.apirest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcarvalho.apirest.domain.Cliente;
import com.elcarvalho.apirest.exceptions.ObjectNotFoundException;
import com.elcarvalho.apirest.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;

	
	public Cliente buscar(Integer id) {
		
		Optional<Cliente> cliente = repo.findById(id);
		
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
