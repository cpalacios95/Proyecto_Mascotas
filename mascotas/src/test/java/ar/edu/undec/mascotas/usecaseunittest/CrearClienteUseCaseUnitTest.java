package ar.edu.undec.mascotas.usecaseunittest;

import ar.edu.undec.mascotas.domain.Cliente;
import ar.edu.undec.mascotas.repository.ICrearClienteRepository;
import ar.edu.undec.mascotas.usecase.CrearClienteUseCase;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CrearClienteUseCaseUnitTest {


    ICrearClienteRepository crearClienteRepository;

    @Test
    void crearCliente_clienteNoExiste_crearCliente(){

        Cliente cliente = Cliente.getInstance("Palacios", "Cristian", "39700483", LocalDate.of(1996,11,22));

        CrearClienteUseCase crearClienteUseCase = new CrearClienteUseCase(crearClienteRepository);


    }


}
