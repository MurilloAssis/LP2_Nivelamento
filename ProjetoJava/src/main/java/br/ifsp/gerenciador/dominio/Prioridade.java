package br.ifsp.gerenciador.dominio;

import java.util.stream.Stream;

public enum Prioridade {
    BAIXA("B"),
    MEDIA("M"),
    ALTA("A");

    private final String codigo;

    Prioridade(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    //
    public static Prioridade fromCodigo(String codigo) {
        if (codigo == null) return null;
        return Stream.of(Prioridade.values())
                .filter(p -> p.getCodigo().equals(codigo))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Código de prioridade inválido: " + codigo));
    }
}