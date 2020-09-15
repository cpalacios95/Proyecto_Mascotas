package ar.edu.undec.mascotas.usecase;

import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.input.ICrearMascotaInput;
import ar.edu.undec.mascotas.repository.ICrearMascotaRepository;

public class CrearMascotaUseCase implements ICrearMascotaInput {

    private ICrearMascotaRepository crearMascotaRepository;

    public CrearMascotaUseCase(ICrearMascotaRepository crearMascotaRepository) {

        this.crearMascotaRepository = crearMascotaRepository;
    }


    @Override
    public boolean crearMascota(Mascota mascota) {
        return false;
    }
}
