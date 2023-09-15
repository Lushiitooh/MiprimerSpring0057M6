package cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.controller;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Alumno;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Curso;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Profesor;
import cl.awakelab.miprimerspring.service.ICursoService;
import cl.awakelab.miprimerspring.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    ICursoService objCursoService;

    @GetMapping
    public String listarCursos(Model model) {
        List<Curso> listaCursos = objCursoService.listarCursos();
        model.addAttribute("atributoListaCursos", listaCursos);
        return "templateListarCursos";
    }

    @GetMapping("/crearCurso")
    public String mostrarFormularioCrearCurso(Model model){
        List<Profesor> listaProfesores = objCursoService.listarProfesores(); // Obtener la lista de profesores desde el servicio
        List<Alumno> listaAlumnos = objCursoService.listarAlumnos(); // Obtener la lista de alumnos desde el servicio
        model.addAttribute("listaProfesores", listaProfesores);
        model.addAttribute("listaAlumnos", listaAlumnos);
        return "templateFormularioCrearCurso";
    }

    @PostMapping("/crearCurso")
    public String crearCurso(@ModelAttribute Curso curso){
        objCursoService.crearCurso(curso);
        return "redirect:/curso";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarCurso(@PathVariable int id){
        objCursoService.eliminarCurso(id);
        return "redirect:/curso";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioEditarCurso(@PathVariable int id, Model model) {
        Curso curso = objCursoService.listarCursosId(id);
        if (curso == null) {
            return "redirect:/curso";
        }
        model.addAttribute("curso", curso);
        return "templateFormularioEditarCurso";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarCurso(@PathVariable int id, @ModelAttribute Curso curso) {
        objCursoService.actualizarCurso(curso);
        return "redirect:/curso";
    }
}

