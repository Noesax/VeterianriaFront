package pe.edu.unmsm.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="usuarios")
public class DuenoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numero;
    private String nombre_completo;
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private String codigo_verificacion;
}
