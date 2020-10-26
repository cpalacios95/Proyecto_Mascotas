package ar.edu.undec.mascotas.persistence.crud;


import ar.edu.undec.mascotas.persistence.entity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICrearClienteCRUD extends CrudRepository<ClienteEntity, Integer> {

}
