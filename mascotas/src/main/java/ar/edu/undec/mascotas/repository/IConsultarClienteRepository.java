package ar.edu.undec.mascotas.repository;

import ar.edu.undec.mascotas.domain.Cliente;

public interface IConsultarClienteRepository {
    boolean existeCliente(String dni);

    Cliente obtenerCliente(String dni);
}
