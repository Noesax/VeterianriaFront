package pe.edu.unmsm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unmsm.Model.Consulta;
import pe.edu.unmsm.Service.ConsultaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<Consulta> registerConsulta(@RequestBody Consulta consulta) {
        Consulta savedConsulta = consultaService.registerConsulta(consulta);
        return ResponseEntity.ok(savedConsulta);
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> getAllConsultas() {
        List<Consulta> consultas = consultaService.getAllConsultas();
        return ResponseEntity.ok(consultas);
    }

    @GetMapping("/{consultaId}")
    public ResponseEntity<Consulta> getConsultaById(@PathVariable Long consultaId) {
        Optional<Consulta> consulta = consultaService.getConsultaById(consultaId);
        return consulta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/mascota/{mascotaId}")
    public ResponseEntity<List<Consulta>> getConsultasByMascotaId(@PathVariable Long mascotaId) {
        List<Consulta> consultas = consultaService.getConsultasByMascotaId(mascotaId);
        return ResponseEntity.ok(consultas);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Consulta>> getConsultasByUsuarioId(@PathVariable Long usuarioId) {
        List<Consulta> consultas = consultaService.getConsultasByUsuarioId(usuarioId);
        return ResponseEntity.ok(consultas);
    }

    @GetMapping("/consMascotas/{mascotaId}&{usuarioId}")
    public ResponseEntity<List<Consulta>> getConsultasByMascotasIdAndUsuarioId(@PathVariable Long mascotaId, @PathVariable Long usuarioId) {
        List<Consulta> consultas = consultaService.getConsultasByMascotaIdAndUsuarioId(mascotaId, usuarioId);
        return ResponseEntity.ok(consultas);
    }
}
