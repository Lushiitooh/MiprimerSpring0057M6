package cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.restcontroller;


import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Curso;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Profesor;
import cl.awakelab.miprimerspring.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curso)")
public class CursoRestController {
    @Autowired
    ICursoService objCursoService;

    @PostMapping
    public Curso crearCurso (@RequestBody Curso curso){
        return objCursoService.crearCurso(curso);
    }

    @PutMapping("/{id}")
    public Curso actualizarCurso(@RequestBody Curso curso){
        return objCursoService.actualizarCurso(curso);
    }

    @GetMapping
    public List<Curso> listarCursos(){

        return objCursoService.listarCursos();
    }

    @GetMapping("/{id}")
    public Curso listarCursosId(@PathVariable int id){

        return objCursoService.listarCursosId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCurso(@PathVariable int id){
        objCursoService.eliminarCurso(id);
        return ResponseEntity.ok("Curso eliminado exitosamente");
    }

}
