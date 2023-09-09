package cl.awakelab.miprimerspring.service;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Alumno;

import java.util.List;

public interface IAlumnoService {

    public Alumno crearAlumno(Alumno alumno);

    public Alumno actualizarAlumno (Alumno alumno);

    public List<Alumno> listarAlumnos();

    public Alumno listarAlumnosId(int id);

    public void eliminarAlumno(int id);

    Alumno actualizarAlumno(int id,Alumno alumnoActualizado);
}
