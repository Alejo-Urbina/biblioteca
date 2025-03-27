package com.example.ejercicio_biblioteca.repository;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "prestamos")
public class PrestamosEntity {

    public PrestamosEntity(Integer ID, String ISBN, String IDENTIFICACIONUSUARIO, Integer TIPOUSUARIO, Date FECHAMAXIMADEVOLUCION) {
        this.ID = ID;
        this.ISBN = ISBN;
        this.IDENTIFICACIONUSUARIO = IDENTIFICACIONUSUARIO;
        this.TIPOUSUARIO = TIPOUSUARIO;
        this.FECHAMAXIMADEVOLUCION = FECHAMAXIMADEVOLUCION;
    }
    public PrestamosEntity() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ID;


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getIDENTIFICATIONNUMBER() {
        return IDENTIFICACIONUSUARIO;
    }

    public void setIDENTIFICATIONNUMBER(String IDENTIFICACIONUSUARIO) {
        this.IDENTIFICACIONUSUARIO = IDENTIFICACIONUSUARIO;
    }

    public Integer getTIPOUSUARIO() {
        return TIPOUSUARIO;
    }

    public void setTIPOUSUARIO(Integer TIPOUSUARIO) {
        this.TIPOUSUARIO = TIPOUSUARIO;
    }


    String ISBN;
    String IDENTIFICACIONUSUARIO;
    Integer TIPOUSUARIO;
    Date FECHAMAXIMADEVOLUCION;

    public Date getFECHAMAXIMADEVOLUCION() {
        return FECHAMAXIMADEVOLUCION;
    }

    public void setFECHAMAXIMADEVOLUCION(Date FECHAMAXIMADEVOLUCION) {
        this.FECHAMAXIMADEVOLUCION = FECHAMAXIMADEVOLUCION;
    }
}
