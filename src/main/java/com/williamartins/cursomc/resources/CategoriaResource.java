package com.williamartins.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.williamartins.cursomc.domain.Categoria;
import com.williamartins.cursomc.services.CategoriaService;

import javassist.tools.rmi.ObjectNotFoundException;

/*mapeando categoria e o ID*/
@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired /*instacia automaticamente esse objeto..*/
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException { /*@PathVariable = pra mostra que a consulta vem do ID*/
		Categoria obj = service.buscar(id);/*indo no services pedindo para pegar a categoria que contem aquele ID*/
		return ResponseEntity.ok().body(obj);	
	}
}