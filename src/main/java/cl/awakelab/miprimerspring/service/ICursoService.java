package cl.awakelab.miprimerspring.service;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Curso;

import java.util.List;

public interface ICursoService {

    public Curso crearCurso(Curso cursoCreado);

    public Curso actualizarCurso (Curso curso);

    public List<Curso> listarCursos();

    public Curso listarCursosId(int id);

    public boolean eliminarCurso(int id);
}
