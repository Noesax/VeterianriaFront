package pe.edu.unmsm.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.unmsm.Model.Mascota;
import pe.edu.unmsm.Repository.MascotaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    public Mascota registerPet(Mascota pet) {
        return mascotaRepository.save(pet);
    }

    public Optional<Mascota> getPetById(Long petId) {
        return mascotaRepository.findById(petId);
    }

    public Optional<Mascota> updatePet(Long petId, Mascota updatedPet) {
        Optional<Mascota> existingPetOptional = mascotaRepository.findById(petId);
        if (existingPetOptional.isPresent()) {
            Mascota existingPet = existingPetOptional.get();
            existingPet.setNombre(updatedPet.getNombre());
            existingPet.setTipo(updatedPet.getTipo());
            existingPet.setUsuarioId(updatedPet.getUsuarioId()); // Actualizar el ownerId si es necesario
            Mascota savedPet = mascotaRepository.save(existingPet);
            return Optional.of(savedPet);
        } else {
            return Optional.empty();
        }
    }

    public boolean deletePet(Long petId) {
        Optional<Mascota> pet = mascotaRepository.findById(petId);
        if (pet.isPresent()) {
            mascotaRepository.deleteById(petId);
            return true;
        } else {
            return false;
        }
    }

    public List<Mascota> getPetsByOwnerId(Long usuarioId) {
        return mascotaRepository.findByUsuarioId(usuarioId);
    }
}
