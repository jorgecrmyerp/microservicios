package com.jgr.microservicio.app.usuario.models.service;

import org.springframework.stereotype.Service;

import com.jgr.microservicio.app.usuario.models.repository.IAlumnoRepository;
import com.jgr.microservicio.commons.alumnos.models.entity.Alumno;
import com.jgr.microservicio.commons.services.CommonServiceImpl;

@Service
//heredamos de commonserviceimpl que es generica,para usarla le pasamos la entidad
//que es alumno y el repositorio que vamos a usar.
//y a su vez heredamos de su interfaz de servicio 

public class AlumnoServiceImpl extends CommonServiceImpl<Alumno,IAlumnoRepository >implements IAlumnoService{}
	
/*	
antes de extender de commons, cuando lo hacemos tampoco hace falta inyectar la dependencia del repositorio de alumnos,
lo pasamos como parametro de entrada.
Heredamos la clase CommonServiceImpl que tiene definidos todos los metodos CRUD, al ser generico le pasamos el tipo de objeto
que es alumno, el repositorio IAlumnoRepository que es el crud : CrudRepository<Alumno, Long> y esta clase implementa
IAlumnoService, que a su vez hereda de crud

	
	
public class AlumnoServiceImpl implements IAlumnoService{

	@Autowired
	private IAlumnoRepository repositoryAlumno;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Alumno> findAll() {
		return repositoryAlumno.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Alumno> findById(Long id) {
		return repositoryAlumno.findById(id);
	}

	@Override
	@Transactional
	public Alumno save(Alumno alumno) {
		return repositoryAlumno.save(alumno);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repositoryAlumno.deleteById(id);
	}

}
	*/	