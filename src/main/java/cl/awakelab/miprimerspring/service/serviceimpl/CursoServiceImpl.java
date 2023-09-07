package cl.awakelab.miprimerspring.service.serviceimpl;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Curso;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.repository.ICursoRepository;
import cl.awakelab.miprimerspring.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("CursoServiceImpl")
public class CursoServiceImpl implements ICursoService {

    @Autowired
    ICursoRepository objCursoRepo;

    @Override
    public Curso crearCurso(Curso cursoCreado) {
        Curso nuevoCurso = new Curso();
        nuevoCurso= objCursoRepo.save (cursoCreado);
        return nuevoCurso;

    }

    @Override
    public Curso actualizarCurso(Curso curso) {
        Curso cursoActualizado = new Curso();
        cursoActualizado = objCursoRepo.findById(curso.getId()).orElse(null);
        cursoActualizado.setNombreCurso(curso.getNombreCurso());;
        cursoActualizado.setListaProfesores(curso.getListaProfesores());
        cursoActualizado.setListaAlumnos(curso.getListaAlumnos());
        return cursoActualizado;
    }

    @Override
    public List<Curso> listarCursos() {
        List <Curso> listaAMostrarCursos =new ArrayList<>();
        listaAMostrarCursos = objCursoRepo.findAll();
        return listaAMostrarCursos;
    }

    @Override
    public Curso listarCursosId(int id) {
        return objCursoRepo.findById(id).orElse(null);
    }

    @Override
    public boolean eliminarCurso(int id) {
        objCursoRepo.deleteById(id);
        return true;
    }
}
