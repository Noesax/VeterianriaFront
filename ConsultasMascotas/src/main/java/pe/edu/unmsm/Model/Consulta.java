package pe.edu.unmsm.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "consultas_medicas")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private String descripcion;

    @Column(name="mascotaid", nullable=false)
    private Long mascotaId;
    @Column(name="usuarioid", nullable=false)
    private Long usuarioId;
}
