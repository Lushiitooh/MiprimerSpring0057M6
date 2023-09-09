package cl.awakelab.miprimerspring.service;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Curso;

import java.util.List;

public interface ICursoService {

    public Curso crearCurso(Curso curso);

    public Curso actualizarCurso (Curso curso);

    Curso actualizarCurso(int id, Curso cursoActualizado);

    public List<Curso> listarCursos();

    public Curso listarCursosId(int id);

    public void eliminarCurso(int id);
}
