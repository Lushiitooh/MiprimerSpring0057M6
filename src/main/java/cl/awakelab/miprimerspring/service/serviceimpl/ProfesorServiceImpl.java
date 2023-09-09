package cl.awakelab.miprimerspring.service.serviceimpl;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Profesor;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.repository.IProfesorRepository;
import cl.awakelab.miprimerspring.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service ("ProfesorServiceImpl")
public class ProfesorServiceImpl implements IProfesorService {

   @Autowired
    IProfesorRepository objProfesorRepo;

   @Override
    public Profesor crearProfesor(Profesor profesorCreado) {
        Profesor nuevoProfesor= objProfesorRepo.save (profesorCreado);
       return nuevoProfesor;

    }

    @Override
    public Profesor actualizarProfesor(Profesor profesor) {

        return objProfesorRepo.save(profesor);
    }

    @Override
    public Profesor actualizarProfesor(int id, Profesor profesorActualizado) {
        return null;
    }


    @Override
    public List<Profesor> listarProfesores() {
       List <Profesor> listaAMostrarProfesores = objProfesorRepo.findAll();
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
}
