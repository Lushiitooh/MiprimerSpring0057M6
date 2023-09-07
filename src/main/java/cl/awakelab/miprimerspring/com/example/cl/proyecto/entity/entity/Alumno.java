package cl.awakelab.miprimerspring.com.example.cl.proyecto.entity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column (nullable = false, length = 75)
    private String Nombres;

    @Column(length = 30)
    private String Apellido1;

    @Column(length = 30)
    private String Apellido2;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_ Curso", nullable = false)
    private Curso curso;




}
