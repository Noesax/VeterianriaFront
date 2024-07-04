package pe.edu.unmsm.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "mascotas")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String tipo;
    private String raza;
    private Integer edad;

    @Column(name = "usuarioid", nullable = false)
    private Long usuarioId;

}

