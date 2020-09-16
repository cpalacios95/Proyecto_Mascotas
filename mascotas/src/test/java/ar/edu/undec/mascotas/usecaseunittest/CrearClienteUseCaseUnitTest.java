package ar.edu.undec.mascotas.usecaseunittest;

import ar.edu.undec.mascotas.domain.Cliente;
import org.junit.jupiter.api.Test;

public class CrearClienteUseCaseUnitTest {

    @Test
    void crearCliente_clienteNoExiste_crearCliente(){

        Cliente cliente = Cliente.getInstance();

    }


}
