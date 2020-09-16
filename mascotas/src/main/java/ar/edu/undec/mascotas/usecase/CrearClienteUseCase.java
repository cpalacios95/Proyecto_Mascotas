package ar.edu.undec.mascotas.usecase;

import ar.edu.undec.mascotas.domain.Cliente;
import ar.edu.undec.mascotas.input.ICrearClienteInput;
import ar.edu.undec.mascotas.repository.ICrearClienteRepository;

public class CrearClienteUseCase implements ICrearClienteInput {


    private ICrearClienteRepository crearClienteRepository;

    public CrearClienteUseCase(ICrearClienteRepository crearClienteRepository) {

        this.crearClienteRepository = crearClienteRepository;
    }


    @Override
    public boolean crearCliente(Cliente cliente){
        if(crearClienteRepository.existeCliente(cliente.getDni()))
            return false;
        else {
            crearClienteRepository.guardarCliente(cliente);
            return true;
        }
    }

}
