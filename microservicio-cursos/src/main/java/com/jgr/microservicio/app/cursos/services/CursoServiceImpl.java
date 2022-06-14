package com.jgr.microservicio.app.cursos.services;

import org.springframework.stereotype.Service;

import com.jgr.microservicio.app.cursos.models.entity.Curso;
import com.jgr.microservicio.app.cursos.repository.ICursoRepository;
import com.jgr.microservicio.commons.services.CommonServiceImpl;


//Hereda de CommonService, así que como parametro le pasamos la entidad que en este caso es curso
//y el repositorio que va a usar, qeu es ICursoRepository, al ser la implementacion de la capa de sericio
//implementa icursoservice, que a su vez hereda de la interfaz ICommonService que es la que 
//por medio del CommonService tiene definidos los metodos comunes a todas las clases: borrar,listar, buscar por id
//y guardar.La unica que es diferente es la de atualizar,porque dependiendo de cada entidad pueden ser campos distintos
//IGUAL QUE LO QUE HEMOS HECHO EN USUARIOS

//para que se registre como componente spring y podamos inyectarlo
@Service 
public class CursoServiceImpl extends CommonServiceImpl<Curso, ICursoRepository> implements ICursoService {


}
