package ar.edu.undec.mascotas.usecase;

import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.exceptions.MascotaException;
import ar.edu.undec.mascotas.input.ICrearMascotaInput;
import ar.edu.undec.mascotas.repository.ICrearMascotaRepository;

public class CrearMascotaUseCase implements ICrearMascotaInput {

    private ICrearMascotaRepository crearMascotaRepository;

    public CrearMascotaUseCase(ICrearMascotaRepository crearMascotaRepository) {

        this.crearMascotaRepository = crearMascotaRepository;
    }


    @Override
    public boolean crearMascota(Mascota mascota) throws MascotaException {
        if(crearMascotaRepository.existeMascota(mascota.getNombre()))
            throw new MascotaException("La mascota ya existe!");
        else {
            crearMascotaRepository.guardarMascota(mascota);
            return true;
        }
    }
}
