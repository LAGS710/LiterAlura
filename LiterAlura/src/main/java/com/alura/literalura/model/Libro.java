package com.alura.literalura.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "Libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String titulo;

    private String autor;

    @Enumerated(EnumType.STRING)
    private Idiomas idiomas;

    private Double numeroDeDescargas;
    public Libro(){}
    public Libro(DatosLibros datosLibros){
        this.titulo = datosLibros.titulo();
        this.autor = datosLibros.autor().get(0).nombreDeAutor();
        this.idiomas = Idiomas.fromString(datosLibros.idiomas().get(0));
        this.numeroDeDescargas = datosLibros.numeroDeDescargas();
    }

    public Libro(Optional<DatosLibros> datosLibros) {
    }

    @Override
    public String toString() {
        return "------ LIBRO ------ \n" +
                "  Título: " + titulo + "\n" +
                "  Autor: " + autor + "\n" +
                "  Numero de descargas: " + numeroDeDescargas + "\n" +
                "  Idiomas: " + idiomas + "\n" +
                "------------------\n";
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Idiomas getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(Idiomas idiomas) {
        this.idiomas = idiomas;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }
}
