package com.DanSteLlaEs.Registro.persistence.mapper;

import com.DanSteLlaEs.Registro.domain.Document;
import com.DanSteLlaEs.Registro.persistence.entity.Documento;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DocumentMapper {

    @Mappings({
            @Mapping(source = "idDocumental",target = "idDocument"),
            @Mapping(source = "tipoDocumental",target = "typeDocument"),
            @Mapping(source = "nombreLote",target = "nameLot"),
            @Mapping(source = "camposIndexar",target = "indexField"),
            @Mapping(source = "nombreCampos",target = "nameField"),
            @Mapping(source = "nombreTipoDocumental",target = "documentTypeName"),
    })
    Document toDocument(Documento documento);
    List<Document> toDocuments(List<Documento> documents);

    @InheritInverseConfiguration
    Documento toDocumento(Document documento);
}
