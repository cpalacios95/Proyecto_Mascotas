package ar.edu.undec.mascotas.usecaseunittest;

import Mockito.MockitoExtension;
import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.exceptions.MascotaException;
import ar.edu.undec.mascotas.repository.IModificarMascotaRepository;
import ar.edu.undec.mascotas.usecase.ModificarMascotaUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith({MockitoExtension.class})

public class ModificarMascotaUseCaseUnitTest {

    @Mock
    IModificarMascotaRepository modificarMascotaRepository;

    @Test
    void modificarMascota_nombreNoExiste_modificarNombre() throws MascotaException {

        Mascota mascota = Mascota.getInstance("Ringo", "Labrador", LocalDate.of(2005,2,12));

        ModificarMascotaUseCase modificarMascotaUseCase = new ModificarMascotaUseCase(modificarMascotaRepository);

        String nuevoNombre = "Lennon";

        when(modificarMascotaRepository.existeMascota(nuevoNombre)).thenReturn(false);

        when(modificarMascotaRepository.guardarMascota(mascota)).thenReturn(true);

        assertTrue(modificarMascotaUseCase.modificarNombreMascota(mascota, nuevoNombre));
    }

    @Test
    void modificarMascota_nombreExiste_noModificarNombre() throws MascotaException {

        Mascota mascota = Mascota.getInstance("Ringo", "Labrador", LocalDate.of(2005,2,12));

        ModificarMascotaUseCase modificarMascotaUseCase = new ModificarMascotaUseCase(modificarMascotaRepository);

        String nuevoNombre = "Lennon";

        when(modificarMascotaRepository.existeMascota(nuevoNombre)).thenReturn(true);

        when(modificarMascotaRepository.guardarMascota(mascota)).thenReturn(false);

        assertFalse(modificarMascotaUseCase.modificarNombreMascota(mascota, nuevoNombre));

    }

    @Test
    void modificarMascota_modificarRaza() throws MascotaException {

        Mascota mascota = Mascota.getInstance("Ringo", "Labrador", LocalDate.of(2005,2,12));

        ModificarMascotaUseCase modificarMascotaUseCase = new ModificarMascotaUseCase(modificarMascotaRepository);

        String nuevaRaza= "Golden";

        when(modificarMascotaRepository.guardarMascota(mascota)).thenReturn(false);

        assertTrue(modificarMascotaUseCase.modificarRazaMascota(mascota, nuevaRaza));

    }

    @Test
    void modificarMascota_modificarFechaNac() throws MascotaException {

        Mascota mascota = Mascota.getInstance("Ringo", "Labrador", LocalDate.of(2005,2,12));

        ModificarMascotaUseCase modificarMascotaUseCase = new ModificarMascotaUseCase(modificarMascotaRepository);

        LocalDate nuevaFecha= LocalDate.of(2006,10,5);

        when(modificarMascotaRepository.guardarMascota(mascota)).thenReturn(false);

        assertTrue(modificarMascotaUseCase.modificarFechaNacMascota(mascota, nuevaFecha));

    }

}
