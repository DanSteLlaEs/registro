package com.DanSteLlaEs.Registro.persistence.crud;

import com.DanSteLlaEs.Registro.persistence.entity.Documento;
import com.DanSteLlaEs.Registro.persistence.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface PersonaCrudRepository extends CrudRepository<Persona,Integer>{


}
