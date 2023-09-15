package cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.controller;


import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Curso;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Profesor;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Usuario;
import cl.awakelab.miprimerspring.service.ICursoService;
import cl.awakelab.miprimerspring.service.IProfesorService;
import cl.awakelab.miprimerspring.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/profesor")
public class ProfesorController {
    @Autowired
    IProfesorService objProfesorService;

    @Autowired
    ICursoService objCursoService;

    @GetMapping
    public String listarProfesores(Model model){
        List<Profesor> listaProfesores = objProfesorService.listarProfesores();
        model.addAttribute("atributoListaProfesores", listaProfesores);
        return "templateListarProfesores";
    }
    @GetMapping("/crearProfesor")
    public String mostrarFormularioCrearProfesor(Model model){
        List<Curso> listaCursos = objCursoService.listarCursos();
        model.addAttribute("listaCursos", listaCursos);
        return "templateFormularioCrearProfesor";
    }

    @PostMapping("/crearProfesor")
    public String crearProfesor(@ModelAttribute Profesor profesor){
        objProfesorService.crearProfesor(profesor);
        return "redirect:/profesor";

    }

    @PostMapping("/eliminar/{id}")
    public String eliminarProfesor(@PathVariable int id){
        objProfesorService.eliminarProfesor(id);
        return "redirect:/profesor";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioEditarProfesor(@PathVariable int id, Model model) {
        Profesor profesor = objProfesorService.listarProfesoresId(id);
        if (profesor == null) {
            return "redirect:/profesor";
        }
        List<Curso> listaCursos = objCursoService.listarCursos();
        model.addAttribute("profesor", profesor);
        model.addAttribute("listaCursos", listaCursos);
        return "templateFormularioEditarProfesor";
    }


    @PostMapping("/actualizar/{id}")
    public String actualizarProfesor(@PathVariable int id, @ModelAttribute Profesor profesor) {
        Profesor profesorActualizado = objProfesorService.actualizarProfesor(profesor);
        if (profesorActualizado == null){
            return "redirect:/profesor";
        }
        return  "redirect:/profesor";
    }

}
