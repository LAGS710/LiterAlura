package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import static jakarta.persistence.FetchType.EAGER;

@Entity
@Table(name = "Autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(unique = true)
    private String nombreDeAutor;
    private Integer fechaDeNacimiento;
    private Integer fechaDeFallecimiento;

    public Autor(){}

//    public Autor(DatosAutor datosAutor){
//    }

    public Autor(DatosAutor datosAutor){
        this.nombreDeAutor = datosAutor.nombreDeAutor();
        this.fechaDeNacimiento = datosAutor.fechaDeNacimiento();
        this.fechaDeFallecimiento = datosAutor.fechaDeFallecimiento();
    }

    @Override
    public String toString() {
        return "------------- Autor -------------- \n" +
                "  Autor " + nombreDeAutor + "\n" +
                "  Fecha de nacimiento : " + fechaDeNacimiento + "\n" +
                "  Fecha de fallecimiento : " + fechaDeFallecimiento + "\n" +
                "---------------------------------\n";
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNombreDeAutor() {
        return nombreDeAutor;
    }

    public void setNombreDeAutor(String nombreDeAutor) {
        this.nombreDeAutor = nombreDeAutor;
    }

    public Integer getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Integer fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Integer getFechaDeFallecimiento() {
        return fechaDeFallecimiento;
    }

    public void setFechaDeFallecimiento(Integer fechaDeFallecimiento) {
        this.fechaDeFallecimiento = fechaDeFallecimiento;
    }


}
