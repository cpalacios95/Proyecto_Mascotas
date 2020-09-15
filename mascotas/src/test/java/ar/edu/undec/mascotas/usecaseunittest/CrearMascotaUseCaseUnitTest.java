package ar.edu.undec.mascotas.usecaseunittest;

import Mockito.MockitoExtension;
import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.repository.ICrearMascotaRepository;
import ar.edu.undec.mascotas.usecase.CrearMascotaUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;

@ExtendWith({MockitoExtension.class})

public class CrearMascotaUseCaseUnitTest {

    ICrearMascotaRepository crearMascotaRepository;

    @Test
    void crearMascota_mascotaNoExiste_crearMascota(){

        Mascota mascota01= Mascota.getInstance("Ringo", "Labrador", LocalDate.of(2005, 11, 12));

        CrearMascotaUseCase crearmascota = new CrearMascotaUseCase(crearMascotaRepository);

    }

}
