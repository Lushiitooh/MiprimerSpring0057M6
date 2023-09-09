package cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.controller;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Alumno;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Profesor;
import cl.awakelab.miprimerspring.service.IAlumnoService;
import cl.awakelab.miprimerspring.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
    @Autowired
    IAlumnoService objAlumnoService;

    @GetMapping
    public String listarAlumnos(Model model){
        List<Alumno> listaAlumnos = objAlumnoService.listarAlumnos();
        model.addAttribute("atributoListaAlumnos", listaAlumnos);
        return "templateListarAlumnos";
    }
    @GetMapping("/crearAlumno")
    public String MostrarFormularioCrearAlumno(){
        return "templateFormularioCrearAlumno";
    }

    @PostMapping("/crearAlumno")
    public String crearAlumno(@ModelAttribute Alumno alumno){
        objAlumnoService.crearAlumno(alumno);
        return "redirect:/alumno";

    }

    @PostMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable int id){
        objAlumnoService.eliminarAlumno(id);
        return "redirect:/alumno";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioEditarAlumno(@PathVariable int id, Model model) {
        Alumno alumno = objAlumnoService.listarAlumnosId(id);
        if (alumno == null) {
            return "redirect:/alumno";
        }
        model.addAttribute("alumno", alumno);
        return "templateFormularioEditarAlumno";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarAlumno(@PathVariable int id, @ModelAttribute Alumno alumno) {
        // Verificamos si el usuario existe antes de actualizar
        objAlumnoService.actualizarAlumno(alumno);
        return "redirect:/alumno";
    }
}
