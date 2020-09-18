package ar.edu.undec.mascotas.usecase;


import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.exceptions.MascotaException;
import ar.edu.undec.mascotas.input.IModificarMascotaInput;
import ar.edu.undec.mascotas.repository.ICrearMascotaRepository;
import ar.edu.undec.mascotas.repository.IModificarMascotaRepository;

public class ModificarMascotaUseCase implements IModificarMascotaInput {

    IModificarMascotaRepository modificarMascotaRepository;

    public ModificarMascotaUseCase(IModificarMascotaRepository modificarMascotaRepository) {

        this.modificarMascotaRepository=modificarMascotaRepository;
    }

    @Override
    public boolean modificarMascota(Mascota mascota, String nuevoNombre) {
        if (modificarMascotaRepository.existeMascota(nuevoNombre))
            return false;
        else {
            mascota.setNombre(nuevoNombre);
            modificarMascotaRepository.guardarMascota(mascota);
            return true;
        }
    }

}
