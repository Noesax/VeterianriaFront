package pe.edu.unmsm.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="contribuyentes")
public class RucModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String direccion;
    private String direccion_completa;
    private String ruc;
    private String nombre_o_razon_social;
    private String estado;
    private String condicion;
    private String departamento;
    private String provincia;
    private String distrito;
    private String ubigeo_sunat;
}
