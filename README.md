# LiterAlura

Segundo challenge del bloque Java

Este programa consume el API https://gutendex.com/books/

Funcionalidades del programa:

1. Consumo de API para la busqqueda de un libro
2. Almacenar los resultados en una base de datos
3. Listar Libros almacenados en la base de datos
4. Listar autores de los libros almacenados en la base de datos
5. Listar autores vivos en un determinado anio
6. LIstar libros por un determinado idioma(se han considerado espanol, ingles, frances, y portugues para esta funcion)

Tecnologias usadas:

Maven para dependencias -> Gson(https://mvnrepository.com/artifact/com.google.code.gson/gson)/Jackson (https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind)/Spring(https://mvnrepository.com/artifact/org.springframework/spring-core)/ Postgresql(https://mvnrepository.com/artifact/org.postgresql/postgresql) 
Postman para ver los requests y la documentacion oficial de Gutendex  -> https://gutendex.com/
JPA Queries para condiciones, exceptions y consultas -> https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

Conocimientos requiridos para su implementacion
- Consumo y almacenamiento de API, como la deserializacion y conversion de listas a objetos
- Creacion de base de datos y relacion con tables
