package ar.edu.undec.mascotas.repository;

import ar.edu.undec.mascotas.domain.Mascota;

public interface IModificarMascotaRepository {

    boolean existeMascota(String nombre);

    boolean guardarMascota(Mascota mascota);

}
