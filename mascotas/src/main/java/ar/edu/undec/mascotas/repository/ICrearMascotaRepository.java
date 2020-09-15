package ar.edu.undec.mascotas.repository;

import ar.edu.undec.mascotas.domain.Mascota;

public interface ICrearMascotaRepository {
    boolean existeMascota(String nombreMascota);

    boolean guardarMascota(Mascota mascota);
}
