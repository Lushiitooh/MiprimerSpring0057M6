package cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.repository;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepository extends JpaRepository<Curso,Integer> {
}
