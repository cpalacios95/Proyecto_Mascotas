package ar.edu.undec.mascotas.usecase;

import ar.edu.undec.mascotas.domain.Cliente;
import ar.edu.undec.mascotas.input.IConsultarClienteInput;
import ar.edu.undec.mascotas.repository.IConsultarClienteRepository;

public class ConsultarClienteUseCase implements IConsultarClienteInput{

    private IConsultarClienteRepository iConsultarClienteRepository;

    public ConsultarClienteUseCase(IConsultarClienteRepository iConsultarClienteRepository) {

        this.iConsultarClienteRepository= iConsultarClienteRepository;
    }

    @Override
    public String getDatosCliente(String dni) {

        if(iConsultarClienteRepository.existeCliente(dni)){
            Cliente c01= iConsultarClienteRepository.obtenerCliente(dni);
            return c01.toString();
        }
        else
            return "El cliente no existe";
    }
}
