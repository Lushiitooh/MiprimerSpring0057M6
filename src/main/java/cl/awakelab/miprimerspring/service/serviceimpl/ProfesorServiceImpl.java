package cl.awakelab.miprimerspring.service.serviceimpl;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Profesor;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.repository.IProfesorRepository;
import cl.awakelab.miprimerspring.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service ("ProfesorServiceImpl")
public class ProfesorServiceImpl implements IProfesorService {

   @Autowired
    IProfesorRepository objProfesorRepo;

   @Override
    public Profesor crearProfesor(Profesor profesorCreado) {
        Profesor nuevoProfesor = new Profesor();
        nuevoProfesor= objProfesorRepo.save (profesorCreado);
       return nuevoProfesor;

    }

    @Override
    public Profesor actualizarProfesor(Profesor profesor) {
       Profesor profesorActualizado = new Profesor();
       profesorActualizado = objProfesorRepo.findById(profesor.getId()).orElse(null);
       profesorActualizado.setNombres(profesor.getNombres());;
       profesorActualizado.setApellido1(profesor.getApellido1());
       profesorActualizado.setApellido2(profesor.getApellido2());
       profesorActualizado.setListaCursos(profesor.getListaCursos());
        return profesorActualizado;
    }


    @Override
    public List<Profesor> listarProfesores() {
       List <Profesor> listaAMostrarProfesores =new ArrayList<>();
       listaAMostrarProfesores = objProfesorRepo.findAll();
        return listaAMostrarProfesores;
    }

    @Override
    public Profesor listarProfesoresId(int id) {
        return objProfesorRepo.findById(id).orElse(null);
    }

    @Override
    public boolean eliminarProfesor(int id) {
       objProfesorRepo.deleteById(id);
       return true;
    }
}
