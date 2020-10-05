package ar.edu.undec.mascotas.persistence.crud;

import ar.edu.undec.mascotas.persistence.entity.MascotaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICrearMascotaCRUD extends CrudRepository<MascotaEntity, Integer> {



}
