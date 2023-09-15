package cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.restcontroller;


import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Curso;
import cl.awakelab.miprimerspring.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{id}")
    public Curso listarCursosId(@PathVariable int id){

        return objCursoService.listarCursosId(id);
    }

    @PutMapping("/{id}")
    public Curso actualizarCurso(@PathVariable int id, @RequestBody Curso curso){
        return objCursoService.actualizarCurso(id, curso);
    }

    @GetMapping
    public List<Curso> listarCursos(){

        return objCursoService.listarCursos();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String>eliminarCurso(@PathVariable int id){
            objCursoService.eliminarCurso(id);
            return ResponseEntity.ok("Curso eliminado exitosamente");
    }





}
