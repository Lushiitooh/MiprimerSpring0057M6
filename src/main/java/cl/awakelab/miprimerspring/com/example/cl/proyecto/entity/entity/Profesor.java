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
@Table(name = "profesores")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(nullable = false, length = 75)
    private String nombres;

    @Column(length = 30)
    private String apellido1;

    @Column(length = 30)
    private String apellido2;

    //@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
 //   @JoinTable(name = "Curso_Profesor",
         //  joinColumns = @JoinColumn(name = "profesor_id", nullable = false),
          //  inverseJoinColumns = @JoinColumn(name = "curso_id", nullable = false)
   // )
  //  private List<Curso> listaCursos;//

    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinTable(name = "Curso_Profesor",
            joinColumns = @JoinColumn(name = "FK_Profesor", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "FK_Curso", nullable = false))
    private List<Curso> listaCursos;
}
