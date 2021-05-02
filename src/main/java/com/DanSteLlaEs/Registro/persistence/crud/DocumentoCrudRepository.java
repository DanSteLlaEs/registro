package com.DanSteLlaEs.Registro.persistence.crud;

import com.DanSteLlaEs.Registro.domain.Document;
import com.DanSteLlaEs.Registro.persistence.entity.Documento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface DocumentoCrudRepository extends CrudRepository<Documento,Integer> {





}
