package cl.awakelab.miprimerspring.service;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Alumno;

import java.util.List;

public interface IAlumnoService {

    public Alumno crearAlumno(Alumno alumnoCreado);

    public Alumno actualizarAlumno (int id,Alumno alumno);

    public List<Alumno> listarAlumnos();

    public Alumno listarAlumnosId(int id);

    public boolean eliminarAlumno(int id);

}
