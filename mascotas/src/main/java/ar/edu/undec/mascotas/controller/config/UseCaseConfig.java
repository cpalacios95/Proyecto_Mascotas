package ar.edu.undec.mascotas.controller.config;

import ar.edu.undec.mascotas.repository.ICrearMascotaRepository;
import ar.edu.undec.mascotas.usecase.CrearMascotaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    //@Autowired
    ICrearMascotaRepository iCrearMascotaRepository;

    @Bean
    public CrearMascotaUseCase crearMascotaUseCase(){
        return new CrearMascotaUseCase(iCrearMascotaRepository);
    }

}
