package com.alura.literalura.model;

public enum Idiomas {
    Español("es"),
    Ingles("en"),
    Frances("fr"),
    Portugues("pt");

    private String idiomaApi;

    Idiomas(String idiomaApi){
        this.idiomaApi = idiomaApi;
    }

    public static Idiomas fromString(String text) {
        for (Idiomas idioma : Idiomas.values()) {
            if (idioma.idiomaApi.equalsIgnoreCase(text)) {
                return idioma;
            }

        }
        throw new IllegalArgumentException("NO HAY LIBROS BAJO ESTE IDIOMA U NO EXISTE TAL IDIOMA: " + text);
    }
}
