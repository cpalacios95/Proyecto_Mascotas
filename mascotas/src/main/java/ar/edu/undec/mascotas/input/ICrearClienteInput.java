package ar.edu.undec.mascotas.input;

import ar.edu.undec.mascotas.domain.Cliente;
import ar.edu.undec.mascotas.exceptions.ClienteException;

public interface ICrearClienteInput {

    boolean crearCliente(Cliente cliente) throws ClienteException;

}
