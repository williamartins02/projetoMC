package com.williamartins.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.williamartins.cursomc.domain.Cliente;
import com.williamartins.cursomc.repositories.ClienteRepository;

import javassist.tools.rmi.ObjectNotFoundException;

/*serviço que oferece operação de consulta de categorias com axulio do repository.  */
@Service
public class ClienteService {

//instanciado o repository ClienteRepository usando a anotação @Autowired
	@Autowired
	private ClienteRepository repo; 

	/*Operação para fazer uma busca no banco de dados atraves do ID da Cliente e 
	 mostra uma execessão caso o ID não existir..
	 ObjectNotFoundException = lança um em todo de execessão casoo id não exista*/
	public Cliente find(Integer id) 
			 throws ObjectNotFoundException { 
		
		 Optional<Cliente> obj = repo.findById(id); /*findById = faz operação de busca de dados, com base no ID.*/
		return obj.orElseThrow(() -> new ObjectNotFoundException( "Objeto não encontrado! Id: " + id + ", Tipo: " 
		     + Cliente.class.getName())); 
		}
}
