package cl.awakelab.miprimerspring.service;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Alumno;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Curso;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Profesor;

import java.util.List;

public interface ICursoService {

    public Curso crearCurso(Curso curso);

    public Curso actualizarCurso (Curso curso);

    Curso actualizarCurso(int id, Curso cursoActualizado);

    public List<Curso> listarCursos();

    void asignarProfesorACurso(Curso curso, Profesor profesor);

    public Curso listarCursosId(int id);

    public void eliminarCurso(int id);

    List<Profesor> listarProfesores();

    List<Alumno> listarAlumnos();

    Curso obtenerCursoPorId(int cursoId);

    List<Profesor> obtenerProfesoresPorCurso(int id);
    List<Profesor> listarProfesoresPorCurso(Curso curso);



}
