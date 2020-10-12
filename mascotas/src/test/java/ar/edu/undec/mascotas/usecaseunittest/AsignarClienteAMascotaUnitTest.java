package ar.edu.undec.mascotas.usecaseunittest;

import Mockito.MockitoExtension;
import ar.edu.undec.mascotas.domain.Cliente;
import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.exceptions.AsignarClienteException;
import ar.edu.undec.mascotas.exceptions.ClienteException;
import ar.edu.undec.mascotas.exceptions.MascotaException;
import ar.edu.undec.mascotas.repository.IAsignarClienteAMascotaReposotory;
import ar.edu.undec.mascotas.usecase.AsignarMascotaUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AsignarClienteAMascotaUnitTest {

    @Mock
    IAsignarClienteAMascotaReposotory asignarClienteAMascotaReposotory;

    @Test
    public void testAsginarCliente_mascotaNoTieneCliente_AsignarCliente() throws ClienteException, MascotaException, AsignarClienteException {

        Cliente cliente = Cliente.getInstance("Palacios", "Cristian", "39700483", LocalDate.of(1996,11,22));

        Mascota mascota = Mascota.getInstance("Ringo", "Labrador", LocalDate.of(2005,11,1));

        AsignarMascotaUseCase asignarMascotaUseCase = new AsignarMascotaUseCase(asignarClienteAMascotaReposotory);

        when(asignarClienteAMascotaReposotory.buscarMascota(mascota.getNombre())).thenReturn(mascota);
        when(asignarClienteAMascotaReposotory.tieneDuenio(mascota)).thenReturn(false);
        when(asignarClienteAMascotaReposotory.asignarCliente(cliente)).thenReturn(true);

        assertTrue(asignarMascotaUseCase.asignarClienteAMascota(cliente, mascota.getNombre()));

    }


    @Test
    public void testAsginarCliente_mascotaTieneCliente_NoAsignarCliente() throws MascotaException, ClienteException {
        Cliente cliente = Cliente.getInstance("Palacios", "Cristian", "39700483", LocalDate.of(1996,11,22));

        Mascota mascota = Mascota.getInstance("Ringo", "Labrador", LocalDate.of(2005,11,1));

        AsignarMascotaUseCase asignarMascotaUseCase = new AsignarMascotaUseCase(asignarClienteAMascotaReposotory);

        when(asignarClienteAMascotaReposotory.buscarMascota(mascota.getNombre())).thenReturn(mascota);
        when(asignarClienteAMascotaReposotory.tieneDuenio(mascota)).thenReturn(true);

        assertThrows(AsignarClienteException.class, () -> asignarMascotaUseCase.asignarClienteAMascota(cliente, mascota.getNombre()));

    }

}
