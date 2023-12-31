package cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.restcontroller;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Alumno;
import cl.awakelab.miprimerspring.service.IAlumnoService;
import cl.awakelab.miprimerspring.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoRestController {
    @Autowired
    IAlumnoService objAlumnoService;

    @Autowired
    ICursoService objCursoService;

    @PostMapping
    public Alumno crearAlumno(@RequestBody Alumno alumno) {

        return objAlumnoService.crearAlumno(alumno);
    }

    @GetMapping("/{id}")
    public Alumno listarAlumnosId(@PathVariable int id) {

        return objAlumnoService.listarAlumnosId(id);
    }

    @PutMapping("/{id}")
    public Alumno actualizarAlumno(@PathVariable int id, @RequestBody Alumno alumno) {
        return objAlumnoService.actualizarAlumno(id, alumno);
    }

    @GetMapping
    public List<Alumno> listarAlumnos() {

        return objAlumnoService.listarAlumnos();
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAlumno(@PathVariable int id) {
        objAlumnoService.eliminarAlumno(id);
        return ResponseEntity.ok("Alumno eliminado exitosamente");
    }

}
