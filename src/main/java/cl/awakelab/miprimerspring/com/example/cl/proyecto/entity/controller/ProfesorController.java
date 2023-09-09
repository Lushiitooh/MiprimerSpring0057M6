package cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.controller;


import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Profesor;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Usuario;
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

    @GetMapping
    public String listarProfesores(Model model){
        List<Profesor> listaProfesores = objProfesorService.listarProfesores();
        model.addAttribute("atributoListaProfesores", listaProfesores);
        return "templateListarProfesores";
    }
    @GetMapping("/crearProfesor")
    public String MostrarFormularioCrearProfesor(){
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
        model.addAttribute("profesor", profesor);
        return "templateFormularioEditarProfesor";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarProfesor(@PathVariable int id, @ModelAttribute Profesor profesor) {
        // Verificamos si el usuario existe antes de actualizar
        objProfesorService.actualizarProfesor(profesor);
        return "redirect:/profesor";
    }
}
