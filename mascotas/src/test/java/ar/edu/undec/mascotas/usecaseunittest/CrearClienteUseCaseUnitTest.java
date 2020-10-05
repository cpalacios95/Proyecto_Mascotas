package ar.edu.undec.mascotas.usecaseunittest;

import Mockito.MockitoExtension;
import ar.edu.undec.mascotas.domain.Cliente;
import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.exceptions.ClienteException;
import ar.edu.undec.mascotas.exceptions.MascotaException;
import ar.edu.undec.mascotas.repository.ICrearClienteRepository;
import ar.edu.undec.mascotas.repository.ICrearMascotaRepository;
import ar.edu.undec.mascotas.usecase.CrearClienteUseCase;
import ar.edu.undec.mascotas.usecase.CrearMascotaUseCase;
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
    @Mock
    ICrearMascotaRepository crearMascotaRepository;

    @Test
    void crearCliente_clienteNoExiste_crearCliente() throws ClienteException, MascotaException {

        Cliente cliente = Cliente.getInstance("Palacios", "Cristian", "39700483", LocalDate.of(1996,11,22));

        CrearClienteUseCase crearClienteUseCase = new CrearClienteUseCase(crearClienteRepository);

        when(crearClienteRepository.existeCliente(cliente.getDni())).thenReturn(false);
        when(crearClienteRepository.guardarCliente(cliente)).thenReturn(true);

        assertTrue(crearClienteUseCase.crearCliente(cliente));

    }

    @Test
    void crearCliente_clienteExiste_noCrearCliente() throws ClienteException {

        Cliente cliente = Cliente.getInstance("Palacios", "Cristian", "39700483", LocalDate.of(1996,11,22));

        CrearClienteUseCase crearClienteUseCase = new CrearClienteUseCase(crearClienteRepository);

        when(crearClienteRepository.existeCliente(cliente.getDni())).thenReturn(true);

        assertThrows(ClienteException.class, ()-> crearClienteUseCase.crearCliente(cliente));

    }

    @Test
    void crearCliente_mascotaNoExiste_addMascota() throws MascotaException, ClienteException {

        Cliente cliente = Cliente.getInstance("Palacios", "Cristian", "39700483", LocalDate.of(1996,11,22));

        Mascota mascota01 = Mascota.getInstance("Ringo", "Labrador", LocalDate.of(2005,8,11));
        Mascota mascota02 = Mascota.getInstance("Tomi", "Caniche", LocalDate.of(2010,8,11));
        Mascota mascota03 = Mascota.getInstance("Leon", "Callejero", LocalDate.of(2009,8,11));

        CrearMascotaUseCase mascotaUseCase = new CrearMascotaUseCase(crearMascotaRepository);

        when(crearMascotaRepository.existeMascota(mascota01.getNombre())).thenReturn(false);
        when(crearMascotaRepository.existeMascota(mascota02.getNombre())).thenReturn(false);
        when(crearMascotaRepository.existeMascota(mascota03.getNombre())).thenReturn(false);

        boolean expected01 = mascotaUseCase.crearMascota(mascota01);
        boolean expected02 = mascotaUseCase.crearMascota(mascota02);
        boolean expected03 = mascotaUseCase.crearMascota(mascota03);

        assertTrue(cliente.addMascotaCliente(mascota01, expected01));
        assertTrue(cliente.addMascotaCliente(mascota01, expected02));
        assertTrue(cliente.addMascotaCliente(mascota01, expected03));

    }

    @Test
    void crearCliente_mascotaExiste_noAddMascota() throws MascotaException, ClienteException {

        Cliente cliente = Cliente.getInstance("Palacios", "Cristian", "39700483", LocalDate.of(1996,11,22));

        Mascota mascota01 = Mascota.getInstance("Ringo", "Labrador", LocalDate.of(2005,8,11));
        Mascota mascota02 = Mascota.getInstance("Tomi", "Caniche", LocalDate.of(2010,8,11));
        Mascota mascota03 = Mascota.getInstance("Leon", "Callejero", LocalDate.of(2009,8,11));

        CrearMascotaUseCase mascotaUseCase = new CrearMascotaUseCase(crearMascotaRepository);

        when(crearMascotaRepository.existeMascota(mascota01.getNombre())).thenReturn(true);
        when(crearMascotaRepository.existeMascota(mascota02.getNombre())).thenReturn(true);
        when(crearMascotaRepository.existeMascota(mascota03.getNombre())).thenReturn(true);

        boolean expected01 = mascotaUseCase.crearMascota(mascota01);
        boolean expected02 = mascotaUseCase.crearMascota(mascota02);
        boolean expected03 = mascotaUseCase.crearMascota(mascota03);

        assertFalse(cliente.addMascotaCliente(mascota01, expected02));
        assertFalse(cliente.addMascotaCliente(mascota01, expected01));
        assertFalse(cliente.addMascotaCliente(mascota01, expected03));

    }

    @Test
    void crearCliete_apellidoVacio(){

        assertThrows(ClienteException.class, () -> Cliente.getInstance("", "Cristian", "39700483", LocalDate.of(2005, 11, 12)));
    }

    @Test
    void crearCliete_apellidoNulo(){

        assertThrows(NullPointerException.class, () -> Cliente.getInstance(null, "Cristian", "39700483", LocalDate.of(2005, 11, 12)));
    }

    @Test
    void crearCliete_nombreVacio(){

        assertThrows(ClienteException.class, () -> Cliente.getInstance("Palacios", "", "39700483", LocalDate.of(2005, 11, 12)));
    }
    @Test
    void crearCliete_nombreNulo(){

        assertThrows(NullPointerException.class, () -> Cliente.getInstance("Palacios", null, "39700483", LocalDate.of(2005, 11, 12)));
    }

    @Test
    void crearCliente_fachaInvalidaMenorDeEdad(){

        assertThrows(ClienteException.class, () -> Cliente.getInstance("Palacios", "Cristian", "39700483",LocalDate.of(2005, 11, 12)));
    }

    @Test
    void crearCliente_fachaInvalidaMayorAFechaLimite(){

        assertThrows(ClienteException.class, () -> Cliente.getInstance("Palacios", "Cristian", "39700483",LocalDate.of(2022, 11, 12)));
    }

    @Test
    void crearCliente_DniInvalido(){

        assertThrows(ClienteException.class, () -> Cliente.getInstance("Palacios", "Cristian", "39700483",LocalDate.of(2022, 11, 12)));
    }

}
