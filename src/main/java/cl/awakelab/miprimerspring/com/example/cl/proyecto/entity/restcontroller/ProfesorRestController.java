package cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.restcontroller;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Profesor;
import cl.awakelab.miprimerspring.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesor)")
public class ProfesorRestController {
    @Autowired
    IProfesorService objProfesorService;

    @PostMapping
    public Profesor crearProfesor (@RequestBody Profesor profesor){
        return objProfesorService.crearProfesor(profesor);
    }

    @PutMapping("/{id}")
    public Profesor actualizarProfesor(@RequestBody Profesor profesor){
        return objProfesorService.actualizarProfesor(profesor);
    }



    @GetMapping
    public List<Profesor> listarProfesores(){

        return objProfesorService.listarProfesores();
    }

    @GetMapping("/{id}")
    public Profesor listarProfesoresId(@PathVariable int id){

        return objProfesorService.listarProfesoresId(id);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProfesor(@PathVariable int id){
        objProfesorService.eliminarProfesor(id);
        return ResponseEntity.ok("Profesor eliminado exitosamente");
    }


}
