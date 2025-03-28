package com.example.ejercicio_biblioteca.dto;

public class PrestamoRequest {
    String isbn;
    String identificacionUsuario;
    Integer tipoUsuario;

    public PrestamoRequest() {

    }

    public PrestamoRequest(String isbn, String identificacionUsuario, Integer tipoUsuario) {
        this.isbn = isbn;
        this.identificacionUsuario = identificacionUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
