package cl.awakelab.miprimerspring.service.serviceimpl;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Curso;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Profesor;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.repository.ICursoRepository;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.repository.IProfesorRepository;
import cl.awakelab.miprimerspring.service.ICursoService;
import cl.awakelab.miprimerspring.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service ("profesorServiceImpl")
public class ProfesorServiceImpl implements IProfesorService {

   @Autowired
    IProfesorRepository objProfesorRepo;

   @Autowired
    ICursoRepository objCursoRepo;

   @Override
    public Profesor crearProfesor(Profesor profesorCreado) {
       List<Curso> cursosSeleccionados = profesorCreado.getListaCursos();
       for (Curso curso : cursosSeleccionados) {
           curso.getListaProfesores().add(profesorCreado);
       }
       Profesor nuevoProfesor= objProfesorRepo.save(profesorCreado);
       return nuevoProfesor;

    }

    @Override
    public Profesor actualizarProfesor(Profesor profesor) {

        return objProfesorRepo.save(profesor);
    }

  //  @Override
   // public Profesor actualizarProfesor(int id, Profesor profesorActualizado) {
      //  return null;//
    //}//


    @Override
    public List<Profesor> listarProfesores() {
       List <Profesor> listaAMostrarProfesores = new ArrayList<>();
       listaAMostrarProfesores = objProfesorRepo.findAll();
       return listaAMostrarProfesores;
    }


    @Override
    public Profesor listarProfesoresId(int id) {

       return objProfesorRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarProfesor(int id) {
        if (objProfesorRepo.existsById(id)) {
            objProfesorRepo.deleteById(id);
        } else {
            System.out.println("El profesor con ID " + id + " no existe.");
        }
    }

    //@Override
  //  public List<Profesor> listarProfesoresPorCurso(Curso curso) {
     //   return null;
 //   }
}
