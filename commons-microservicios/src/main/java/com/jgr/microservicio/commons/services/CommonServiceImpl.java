package com.jgr.microservicio.commons.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

//implementa la interfaz que es generica y ademas el crudrepository que tb va a ser generico
//La E indica que tb es generico y como parametro le pasamos otra interfaz que extiende de crud repository
//llamada r, y como cualquier crud tiene como parametros el nombre del repositorio ,que en este caso al ser 
//generico tb ponemos E y ademas el tipo de dato de la clave,que es un long

//Aqui no hace falta el @Service porque no es un componente a inyectar,vamos a heredar de ella directamente

//@Service
public class CommonServiceImpl<E,R extends CrudRepository<E,Long>> implements ICommonService<E>{

	
	//lo dejamos como protected para que las clases que hereden puedan usarlo
	@Autowired
	protected R repository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<E> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<E> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public E save(E entity) {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
