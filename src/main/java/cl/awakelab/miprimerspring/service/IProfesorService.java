package cl.awakelab.miprimerspring.service;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Curso;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Profesor;

import java.util.List;

public interface IProfesorService {

    public Profesor crearProfesor(Profesor profesor);

    public Profesor actualizarProfesor(Profesor profesor);

  //  Profesor actualizarProfesor(int id, Profesor profesorActualizado);//

    public List<Profesor> listarProfesores();

    public Profesor listarProfesoresId(int id);

    public void eliminarProfesor(int id);

   // List<Profesor> listarProfesoresPorCurso(Curso curso);//
}
