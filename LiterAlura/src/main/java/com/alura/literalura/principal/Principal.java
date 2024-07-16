package com.alura.literalura.principal;
import com.alura.literalura.model.*;
import com.alura.literalura.repository.AutorRepositorio;
import com.alura.literalura.repository.LibroRepositorio;
import com.alura.literalura.service.ConsumoAPI;
import com.alura.literalura.service.ConvierteDatos;
import java.util.Scanner;  // Import the Scanner class

import java.util.*;

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);
    private List<Libro> libros;
    private List<Autor> autores;
    private LibroRepositorio libroRepositorio;
    private AutorRepositorio autorRepositorio;
    public Principal(LibroRepositorio libroRepositorio, AutorRepositorio autorRepositorio) {
        this.libroRepositorio = libroRepositorio;
        this.autorRepositorio = autorRepositorio;
    }


    public void muestraElMenu() {
        var json = consumoAPI.obtenerDatos(URL_BASE);

        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar libro por titulo
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.flush();
                    buscarLibro();
                    break;
                case 2:
                    listaLibro();
                    break;
                case 3:
                    listaAutores();
                    break;
                case 4:
                    listaAutoresVivos();
                    break;
                case 5:
                    BuscarLibroIdioma();
                    break;
                case 0:
                    System.out.println("Adios!");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
        //funcion auxiliar para la busqueda y conversor de la lista un objeto
        private Datos obtenerDatosLibro() {
            System.out.println("Ingrese el nombre del libro que desea buscar");
            var tituloLibro = teclado.nextLine();
            var json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + tituloLibro.replace(" ", "+"));
            Datos datos = conversor.obtenerDatos(json, Datos.class);

            return datos;
        }

    //funcion principal donde se llama la busqueda y se guardan los primeros resultados
    private void buscarLibro(){
        Datos datos = obtenerDatosLibro();

        try {
            Libro libro = new Libro(datos.libros().get(0)); //solo recibe primer busqueda
            Autor autor = new Autor(datos.libros().get(0).autor().get(0)); //solo registra primer autor

            libroRepositorio.save(libro);//guarda los autores y libros
            autorRepositorio.save(autor);

            System.out.println(libro);

            //en caso de no hallar el libro
        }catch (Exception e){
            System.out.println("no se encontro ese libro");
        }
    }

    //funcion find all hace un SELECT * practicamente
    private void listaLibro(){
        libros = libroRepositorio.findAll();
        libros.stream().forEach(libro -> System.out.println(libro));
    }
    //lo mismo de la funcion anterior excepto con autores
    private void listaAutores(){
       autores = autorRepositorio.findAll();
       autores.stream().forEach(autor -> System.out.println(autor));
    }
    // pasa el parametro fechaInicio como el parametro, se que debi llamarla consultaFecha o algo asi jeje
    private void listaAutoresVivos(){
        System.out.println("Ingresa el año a partir del cual buscar:");
        var fechaInicio = teclado.nextInt();
        teclado.nextLine();
        List<Autor> autor = autorRepositorio.autorPorFecha(fechaInicio);
        if(autor.isEmpty()){
            System.out.println("no hay autor vivo durante este periodo");}
        else {
            System.out.println(autor);
        }
        }
    //busca por idioma, los resultados se habran almacenado como nombres completos de idiomas pero se siguen consultando como en/es/etc.
    public void BuscarLibroIdioma() {

        String languagesList = """
                Elija entre las opciones del idioma del libro que desea buscar
                
                en - Inglés
                es - Español
                fr - Francés
                it - Italiano
                pt - Portugués
                
                """;
        System.out.println(languagesList);
        String text =  teclado.nextLine();

        var language = Idiomas.fromString(text);

        List<Libro> bookLanguage = libroRepositorio.findByIdiomas(language);

        if (bookLanguage.isEmpty()){
            System.out.println("No hay libros bajo esta categoria");
        }
        bookLanguage.stream()
                .forEach(System.out::println);
          }
    }