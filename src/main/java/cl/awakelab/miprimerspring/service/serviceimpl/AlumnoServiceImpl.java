package cl.awakelab.miprimerspring.service.serviceimpl;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Alumno;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.repository.IAlumnoRepository;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.repository.ICursoRepository;
import cl.awakelab.miprimerspring.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AlumnoServiceImpl")
public class AlumnoServiceImpl implements IAlumnoService {

    @Autowired
    IAlumnoRepository objAlumnoRepo;

    //@Autowired//
   // ICursoRepository objCursoRepo;//

    @Override
    public Alumno crearAlumno(Alumno alumnoCreado) {
        Alumno nuevoAlumno =  objAlumnoRepo.save(alumnoCreado);
        return nuevoAlumno;
    }

    @Override
    public Alumno actualizarAlumno(Alumno alumno) {

        return objAlumnoRepo.save(alumno);
    }

    @Override
    public Alumno actualizarAlumno(int id, Alumno alumnoActualizado) {
        return null;
    }

    @Override
    public List<Alumno> listarAlumnos() {
        List <Alumno> listaAMostrarAlumnos = objAlumnoRepo.findAll();
        return listaAMostrarAlumnos;
    }

    @Override
    public Alumno listarAlumnosId(int id) {

        return objAlumnoRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarAlumno(int id) {
        if (objAlumnoRepo.existsById(id)) {
            objAlumnoRepo.deleteById(id);
        } else {
            System.out.println("El alumno con ID " + id + " no existe.");
        }
    }




}
