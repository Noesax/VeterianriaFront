package pe.edu.unmsm.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.unmsm.Model.RucModel;
import pe.edu.unmsm.Repository.RucRepository;

import java.util.Optional;

@Service
public class RucService {

    @Autowired
    private RucRepository rucRepository;
    public Optional<RucModel> findByRuc(String ruc) {
        return rucRepository.findByRuc(ruc);
    }

    public RucModel save(RucModel ruc) {
        return rucRepository.save(ruc);
    }
}
