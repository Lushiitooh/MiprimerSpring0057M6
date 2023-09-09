package cl.awakelab.miprimerspring.service;


import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    public Usuario crearUsuario(Usuario usuario);

    public Usuario actualizarUsuario (Usuario usuario);

    Usuario actualizarUsuario(int id, Usuario usuarioActualizado);

    public List<Usuario> listarUsuarios();

    public Usuario listarUsuarioId(int id);

    public void eliminarUsuario(int id);




}
