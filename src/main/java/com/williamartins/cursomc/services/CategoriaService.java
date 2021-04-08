package com.williamartins.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.williamartins.cursomc.domain.Categoria;
import com.williamartins.cursomc.repositories.CategoriaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

/*serviço que oferece operação de consulta de categorias com axulio do repository.  */
@Service
public class CategoriaService {

//instanciado o repository CategoriaRepository usando a anotação @Autowired
	@Autowired
	private CategoriaRepository repo; 

	/*Operação para fazer uma busca no banco de dados atraves do ID da Categoria e 
	 mostra uma execessão caso o ID não existir..
	 ObjectNotFoundException = lança um em todo de execessão casoo id não exista*/
	public Categoria buscar(Integer id) 
			 throws ObjectNotFoundException { 
		 Optional<Categoria> obj = repo.findById(id); /*findById = faz operação de busca de dados, com base no ID.*/
		return obj.orElseThrow(() -> new ObjectNotFoundException( "Objeto não encontrado! Id: " + id + ", Tipo: " 
		     + Categoria.class.getName())); 
		}
	
	/*Metodo para inserir uma categoria usando o Repository
	 * tem objetivo de retorna o repo e salvar*/
	public Categoria insert(Categoria obj) {
		obj.setId(null);/*o obj novo ser inserido tem que ter o id null, se tiver valendo alguma coisa, save considera como atualização NÂO inserção. */
		return repo.save(obj);
	}
	
	
	
	
	
}
