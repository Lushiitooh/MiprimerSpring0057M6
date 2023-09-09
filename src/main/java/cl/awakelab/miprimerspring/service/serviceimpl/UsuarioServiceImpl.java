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
    public Usuario crearUsuario(Usuario usuarioCreado) {
        Usuario nuevoUsuario = objUsuarioRepo.save(usuarioCreado);
        return nuevoUsuario;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        // Implementa la lógica para actualizar el usuario aquí
        // Por ejemplo, puedes usar objUsuarioRepo.save(usuario) para actualizarlo en la base de datos
        return objUsuarioRepo.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(int id, Usuario usuarioActualizado) {
        return null;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> listaAMostrarUsuarios = objUsuarioRepo.findAll();
        return listaAMostrarUsuarios;
    }

    @Override
    public Usuario listarUsuarioId(int id) {

        return objUsuarioRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarUsuario(int id) {
        if (objUsuarioRepo.existsById(id)) {
            objUsuarioRepo.deleteById(id);
        } else {
            System.out.println("El usuario con ID " + id + " no existe.");
        }
    }
}

