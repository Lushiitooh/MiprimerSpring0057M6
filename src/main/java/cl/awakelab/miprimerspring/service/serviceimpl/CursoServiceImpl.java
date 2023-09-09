package cl.awakelab.miprimerspring.service.serviceimpl;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Curso;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.repository.ICursoRepository;
import cl.awakelab.miprimerspring.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CursoServiceImpl")
public class CursoServiceImpl implements ICursoService {

    @Autowired
    ICursoRepository objCursoRepo;

    @Override
    public Curso crearCurso(Curso cursoCreado) {
        Curso nuevoCurso = objCursoRepo.save (cursoCreado);
        return nuevoCurso;

    }

    @Override
    public Curso actualizarCurso(Curso curso) {
        return objCursoRepo.save(curso);
    }

    @Override
    public Curso actualizarCurso(int id, Curso cursoActualizado) {
        return null;
    }

    @Override
    public List<Curso> listarCursos() {
        List <Curso> listaAMostrarCursos = objCursoRepo.findAll();
        return listaAMostrarCursos;
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
}
