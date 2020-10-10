package ar.edu.undec.mascotas.repository;

import ar.edu.undec.mascotas.domain.Mascota;

public interface IConsultarMascotaRepository {
    boolean existeMascota(String nombre);

    Mascota obtenerMascota(String nombre);

}
