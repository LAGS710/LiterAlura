package com.alura.literalura.repository;

import com.alura.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor,Long>{
@Query("SELECT a FROM Autor a WHERE a.fechaDeNacimiento <= :fechaInicio AND a.fechaDeFallecimiento >= :fechaInicio ORDER BY a.fechaDeNacimiento ASC")
List<Autor> autorPorFecha(Integer fechaInicio);
}