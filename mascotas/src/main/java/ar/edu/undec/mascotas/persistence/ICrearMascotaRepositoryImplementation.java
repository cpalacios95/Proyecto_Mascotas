package ar.edu.undec.mascotas.persistence;


import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.repository.ICrearMascotaRepository;

public class ICrearMascotaRepositoryImplementation implements ICrearMascotaRepository {


    @Override
    public boolean existeMascota(String nombreMascota) {
        return false;
    }

    @Override
    public boolean guardarMascota(Mascota mascota) {
        return false;
    }
}
