package ar.edu.undec.mascotas.repository;

import ar.edu.undec.mascotas.domain.Cliente;

public interface IModificarClienteRepository {
    boolean existeCliente(String nuevoDni);

    boolean guardarCliente(Cliente cliente);
}
