package br.ifsp.gerenciador.dominio.converters;

import br.ifsp.gerenciador.dominio.Status;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

//
@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String> {

    //
    @Override
    public String convertToDatabaseColumn(Status status) {
        if (status == null) {
            return null;
        }
        return status.getCodigo(); //
    }

    //
    @Override
    public Status convertToEntityAttribute(String codigo) {
        if (codigo == null) {
            return null;
        }
        return Status.fromCodigo(codigo); //
    }
}
