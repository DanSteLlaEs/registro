package com.DanSteLlaEs.Registro.persistence.mapper;

import com.DanSteLlaEs.Registro.domain.Person;
import com.DanSteLlaEs.Registro.persistence.entity.Persona;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mappings({
            @Mapping(source = "idPersona", target = "idPerson"),
            @Mapping(source = "tipoPersona", target = "typePerson"),
            @Mapping(source = "primerApe", target = "fistSurname"),
            @Mapping(source = "segundoApe", target = "secondSurname"),
            @Mapping(source = "primerNom", target = "fistName"),
            @Mapping(source = "segundoNom", target = "secondsName"),
            @Mapping(source = "tipoDocumento", target = "typeDocument"),
            @Mapping(source = "numeroDocumento", target = "numberDocument"),
            @Mapping(source = "fechaExpedicion", target = "dateExpedition"),
            @Mapping(source = "lugarExpedicion", target = "placeExpedition"),
            @Mapping(source = "pais", target = "country"),
            @Mapping(source = "ciudad", target = "city"),
            @Mapping(source = "direccion", target = "address"),
            @Mapping(source = "telefonoFijo", target = "landline"),
            @Mapping(source = "celular", target = "phone"),
            @Mapping(source = "razonSocial", target = "businessName"),
            @Mapping(source = "cargo", target = "position"),

    })
    Person toPerson(Persona persona);
    List<Person> toPersons(List<Persona> persons);

    @InheritInverseConfiguration
    Persona toPersona(Person person);

}
