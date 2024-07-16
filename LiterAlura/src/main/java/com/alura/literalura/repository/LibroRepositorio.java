package com.alura.literalura.repository;

import com.alura.literalura.model.Idiomas;
import com.alura.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface LibroRepositorio extends JpaRepository<Libro,Long>{
//  @Query(
//          value = "SELECT * FROM Libros WHERE idiomas LIKE 'language'",
//          nativeQuery = true)
    List<Libro> findByIdiomas(Idiomas idiomas);
}
