package pe.edu.unmsm.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.unmsm.Model.Consulta;
import pe.edu.unmsm.Repository.ConsultaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta registerConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public Optional<Consulta> getConsultaById(Long consultaId) {
        return consultaRepository.findById(consultaId);
    }

    public List<Consulta> getConsultasByMascotaId(Long mascotaId) {
        return consultaRepository.findByMascotaId(mascotaId);
    }

    public List<Consulta> getConsultasByUsuarioId(Long usuarioId) {
        return consultaRepository.findByUsuarioId(usuarioId);
    }

    public List<Consulta> getAllConsultas() {
        return consultaRepository.findAll();
    }

    public List<Consulta> getConsultasByMascotaIdAndUsuarioId(Long mascotaId, Long usuarioId) {
        return  consultaRepository.findByMascotaIdAndUsuarioId(mascotaId, usuarioId);
    }
}
