package cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.repository;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {

}
