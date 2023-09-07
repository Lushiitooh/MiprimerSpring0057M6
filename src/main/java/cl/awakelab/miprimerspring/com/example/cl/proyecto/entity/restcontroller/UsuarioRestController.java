package cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.restcontroller;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Usuario;
import cl.awakelab.miprimerspring.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario)")
public class UsuarioRestController {
    @Autowired
    IUsuarioService objUsuarioService;

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario){

        return objUsuarioService.crearUsuario(usuario);
    }

    @PutMapping
    public Usuario actualizarUsuario(@RequestBody Usuario usuario){
        return objUsuarioService.actualizarUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios(){

        return objUsuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario listarUsuarioId(@PathVariable int id){

        return objUsuarioService.listarUsuarioId(id);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable int id){
        objUsuarioService.eliminarUsuario(id);
        return ResponseEntity.ok("Usuario eliminado exitosamente");
    }


}
