package pe.edu.unmsm.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.unmsm.Model.DuenoModel;
import pe.edu.unmsm.Repository.DuenoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DuenoService {
    @Autowired
    private DuenoRepository duenoRepository;

    public String createDueno(DuenoModel duenoModel) {
        Optional<DuenoModel> existingDueno = duenoRepository.findByNumero(duenoModel.getNumero());
        if (existingDueno.isPresent()) {
            return "El DNI ya está registrado.";
        }
        duenoRepository.save(duenoModel);
        return "Datos guardados exitosamente.";
    }

    public List<DuenoModel> getAllDuenos() {
        return duenoRepository.findAll();
    }
}
