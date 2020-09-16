package ar.edu.undec.mascotas.usecaseunittest;

import Mockito.MockitoExtension;
import ar.edu.undec.mascotas.domain.Cliente;
import ar.edu.undec.mascotas.repository.ICrearClienteRepository;
import ar.edu.undec.mascotas.usecase.CrearClienteUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

@ExtendWith({MockitoExtension.class})

public class CrearClienteUseCaseUnitTest {


    @Mock
    ICrearClienteRepository crearClienteRepository;

    @Test
    void crearCliente_clienteNoExiste_crearCliente(){

        Cliente cliente = Cliente.getInstance("Palacios", "Cristian", "39700483", LocalDate.of(1996,11,22));

        CrearClienteUseCase crearClienteUseCase = new CrearClienteUseCase(crearClienteRepository);

        when(crearClienteRepository.existeCliente(cliente.getDni())).thenReturn(false);
        when(crearClienteRepository.guardarCliente(cliente)).thenReturn(true);

        assertTrue(crearClienteUseCase.crearCliente(cliente));



    }


}
