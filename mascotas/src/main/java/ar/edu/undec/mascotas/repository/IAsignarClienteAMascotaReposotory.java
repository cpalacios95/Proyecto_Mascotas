package ar.edu.undec.mascotas.repository;

import ar.edu.undec.mascotas.domain.Cliente;
import ar.edu.undec.mascotas.domain.Mascota;

public interface IAsignarClienteAMascotaReposotory {

    boolean tieneDuenio(Mascota mascota);

    boolean asignarCliente(Cliente cliente);

    Mascota buscarMascota(String nombreMascota);
}
