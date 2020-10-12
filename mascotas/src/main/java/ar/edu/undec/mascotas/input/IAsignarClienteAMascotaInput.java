package ar.edu.undec.mascotas.input;

import ar.edu.undec.mascotas.domain.Cliente;
import ar.edu.undec.mascotas.exceptions.AsignarClienteException;

public interface IAsignarClienteAMascotaInput {

    boolean asignarClienteAMascota(Cliente cliente, String nombreMascota) throws AsignarClienteException;

}
