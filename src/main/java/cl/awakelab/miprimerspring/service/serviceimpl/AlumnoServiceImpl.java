package cl.awakelab.miprimerspring.service.serviceimpl;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Alumno;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.repository.IAlumnoRepository;
import cl.awakelab.miprimerspring.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("alumnoServiceImpl")
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
    public Alumno actualizarAlumno(int id, Alumno alumnoActualizado) {
        Alumno alumnoEncontrado = objAlumnoRepo.findById(id).orElse(null);
        alumnoEncontrado.setNombres(alumnoActualizado.getNombres());
        alumnoEncontrado.setApellido1(alumnoActualizado.getApellido1());
        alumnoEncontrado.setApellido2(alumnoActualizado.getApellido2());
        alumnoEncontrado.setCurso(alumnoActualizado.getCurso());
        return objAlumnoRepo.save(alumnoEncontrado);
    }


    @Override
    public List<Alumno> listarAlumnos() {
        List<Alumno> listarAlumnos = new ArrayList<Alumno>();
        listarAlumnos = objAlumnoRepo.findAll();
        return listarAlumnos;
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

    @Override
    public Alumno actualizarAlumno(Alumno alumno) {
        return null;
    }


}
