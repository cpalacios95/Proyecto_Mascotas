package ar.edu.undec.mascotas.repository;

import ar.edu.undec.mascotas.domain.Cliente;

public interface ICrearClienteRepository {

    boolean guardarCliente(Cliente cliente);
    boolean existeCliente(String dni);


}
