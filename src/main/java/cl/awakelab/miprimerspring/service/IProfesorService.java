package cl.awakelab.miprimerspring.service;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Profesor;

import java.util.List;

public interface IProfesorService {

    public Profesor crearProfesor(Profesor profesorCreado);

    public Profesor actualizarProfesor ( Profesor profesor);

    public List<Profesor> listarProfesores();

    public Profesor listarProfesoresId(int id);

    public boolean eliminarProfesor(int id);
}
