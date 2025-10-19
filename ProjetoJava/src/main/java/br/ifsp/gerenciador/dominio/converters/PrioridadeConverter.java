package br.ifsp.gerenciador.dominio.converters;

import br.ifsp.gerenciador.dominio.Prioridade;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

//
@Converter(autoApply = true)
public class PrioridadeConverter implements AttributeConverter<Prioridade, String> {

    //
    @Override
    public String convertToDatabaseColumn(Prioridade prioridade) {
        if (prioridade == null) {
            return null;
        }
        return prioridade.getCodigo(); //
    }

    //
    @Override
    public Prioridade convertToEntityAttribute(String codigo) {
        if (codigo == null) {
            return null;
        }
        return Prioridade.fromCodigo(codigo); //
    }
}
