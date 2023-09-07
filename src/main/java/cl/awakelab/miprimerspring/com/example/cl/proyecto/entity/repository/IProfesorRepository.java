package cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.repository;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfesorRepository extends JpaRepository<Profesor,Integer> {
}
