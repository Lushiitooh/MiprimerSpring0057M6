package cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static jakarta.persistence.CascadeType.MERGE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String nombreCurso;

    @JsonIgnore
    @ManyToMany(mappedBy = "listaCursos", cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private List<Profesor> listaProfesores;

    @JsonIgnore
    @OneToMany(mappedBy = "curso", cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private List<Alumno> listaAlumnos;
}