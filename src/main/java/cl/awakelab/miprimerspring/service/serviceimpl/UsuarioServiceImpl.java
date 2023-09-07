package cl.awakelab.miprimerspring.service.serviceimpl;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Usuario;
import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.repository.IUsuarioRepository;
import cl.awakelab.miprimerspring.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    IUsuarioRepository objUsuarioRepo;

    @Override
    public Usuario crearUsuario(Usuario usuarioCreado){
        Usuario nuevoUsuario= new Usuario();
        nuevoUsuario= objUsuarioRepo.save (usuarioCreado);
        return nuevoUsuario;

    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        Usuario usuarioActualizado = new Usuario();
        usuarioActualizado = objUsuarioRepo.findById(usuario.getId()).orElse(null);
        usuarioActualizado.setNombre(usuario.getNombre());
        usuarioActualizado.setRol(usuario.getRol());
        usuarioActualizado.setContrasena(usuario.getContrasena());
        objUsuarioRepo.save(usuarioActualizado);
        return usuarioActualizado;
    }


    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> listaAMostrarUsuarios =new ArrayList<>();
        listaAMostrarUsuarios= objUsuarioRepo.findAll();
        return listaAMostrarUsuarios;

    }

    @Override
    public Usuario listarUsuarioId(int id) {
        return objUsuarioRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarUsuario(int id) {
    }


}
