package com.jgr.microservicio.commons.services;

import java.util.Optional;


//EL <E> indica que es una clase generica
public interface ICommonService<E> {
	
	public Iterable<E> findAll();
	
	public Optional<E> findById(Long id);
	
	public E save(E entidad);
	
	public void deleteById(Long id);
	

}
