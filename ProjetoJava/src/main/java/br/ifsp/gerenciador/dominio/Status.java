package br.ifsp.gerenciador.dominio;

import java.util.stream.Stream;

public enum Status {
    A_FAZER("AF"),
    FAZENDO("FZ"),
    FEITO("FT");

    private final String codigo;

    Status(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    //
    public static Status fromCodigo(String codigo) {
        if (codigo == null) return null;
        return Stream.of(Status.values())
                .filter(s -> s.getCodigo().equals(codigo))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Código de status inválido: " + codigo));
    }
}