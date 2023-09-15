package cl.awakelab.miprimerspring.service.serviceimpl;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Alumno;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Curso;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Profesor;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.repository.IAlumnoRepository;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.repository.ICursoRepository;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.repository.IProfesorRepository;
import cl.awakelab.miprimerspring.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("cursoServiceImpl")
public class CursoServiceImpl implements ICursoService {

    @Autowired
    private ICursoRepository objCursoRepo;

    @Autowired
    private IProfesorRepository objProfesorRepo;

    @Autowired
    private IAlumnoRepository objAlumnoRepo;

    @Override
    public Curso crearCurso(Curso cursoCreado) {
        Curso nuevoCurso = objCursoRepo.save(cursoCreado);
        return objCursoRepo.save(cursoCreado);
    }

    @Override
    public Curso actualizarCurso(Curso curso) {
        return objCursoRepo.save(curso);
    }

    @Override
    public Curso actualizarCurso(int id, Curso cursoActualizado) {
        Curso cursoEncontrado = objCursoRepo.findById(id).orElse(null);
        cursoEncontrado.setNombreCurso(cursoActualizado.getNombreCurso());
        return objCursoRepo.save(cursoEncontrado);
    }

    @Override
    public List<Curso> listarCursos() {
        List<Curso> listaCursos = new ArrayList<>();
        listaCursos = objCursoRepo.findAll();
        return listaCursos;
    }


    @Override
    public void asignarProfesorACurso(Curso curso, Profesor profesor){
        curso.getListaProfesores().add(profesor);
        objCursoRepo.save(curso);
    }

    @Override
    public Curso listarCursosId(int id) {
        return objCursoRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarCurso(int id) {
        if (objCursoRepo.existsById(id)) {
            objCursoRepo.deleteById(id);
        } else {
            System.out.println("El curso con ID " + id + " no existe.");
        }
    }


    @Override
    public List<Profesor> listarProfesores() {
        return objProfesorRepo.findAll(); // Obtener la lista de profesores desde el repositorio de profesores
    }

    @Override
    public List<Alumno> listarAlumnos() {
        return objAlumnoRepo.findAll(); // Obtener la lista de alumnos desde el repositorio de alumnos
    }

    @Override
    public Curso obtenerCursoPorId(int id) {
        return objCursoRepo.findById(id).orElse(null);
    }

    @Override
    public List<Profesor> obtenerProfesoresPorCurso(int id) {
        Curso curso = objCursoRepo.findById(id).orElse(null);
        if (curso != null) {
            return curso.getListaProfesores();
        }
        return Collections.emptyList(); // Devuelve una lista vacía si el curso no se encuentra
    }

    @Override
    public List<Profesor> listarProfesoresPorCurso(Curso curso) {
        return null;
    }

}


