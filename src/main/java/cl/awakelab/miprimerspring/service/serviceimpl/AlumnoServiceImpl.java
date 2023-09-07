package cl.awakelab.miprimerspring.service.serviceimpl;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Alumno;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Curso;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.repository.IAlumnoRepository;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.repository.ICursoRepository;
import cl.awakelab.miprimerspring.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("AlumnoServiceImpl")
public class AlumnoServiceImpl implements IAlumnoService {

    @Autowired
    IAlumnoRepository objAlumnoRepo;

    @Autowired
    ICursoRepository objCursoRepo;

    @Override
    public Alumno crearAlumno(Alumno alumnoCreado) {
        Alumno nuevoAlumno = new Alumno();
        Curso cursoAsignado = new Curso();
        cursoAsignado = objCursoRepo.findById(alumnoCreado.getCurso().getId()).orElse(null);
        alumnoCreado.setCurso(cursoAsignado);
        nuevoAlumno = objAlumnoRepo.save(alumnoCreado);
        return nuevoAlumno;

    }

    @Override
    public Alumno actualizarAlumno(int id, Alumno alumno) {
        Alumno alumnoActualizado = new Alumno();
        alumnoActualizado = objAlumnoRepo.findById(alumno.getId()).orElse(null);
        alumnoActualizado.setNombres(alumno.getNombres());
        alumnoActualizado.setApellido1(alumno.getApellido1());
        alumnoActualizado.setApellido2(alumno.getApellido2());
        alumnoActualizado.setCurso(alumno.getCurso());
        return alumnoActualizado;
    }

    @Override
    public List<Alumno> listarAlumnos() {
        List <Alumno> listaAMostrarAlumnos =new ArrayList<>();
        listaAMostrarAlumnos = objAlumnoRepo.findAll();
        return listaAMostrarAlumnos;
    }

    @Override
    public Alumno listarAlumnosId(int id) {
        return objAlumnoRepo.findById(id).orElse(null);
    }

    @Override
    public boolean eliminarAlumno(int id) {
        objAlumnoRepo.deleteById(id);
        return true;
    }






}
