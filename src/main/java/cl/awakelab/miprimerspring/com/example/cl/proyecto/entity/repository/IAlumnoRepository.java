package cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.repository;

import cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlumnoRepository extends JpaRepository<Alumno,Integer> {
}
