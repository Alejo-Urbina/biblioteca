package com.example.ejercicio_biblioteca.service.interfaces;


import com.example.ejercicio_biblioteca.dto.InformacionPrestamo;
import com.example.ejercicio_biblioteca.dto.PrestamoRequest;
import com.example.ejercicio_biblioteca.dto.PrestamoResponse;

public interface PrestamoService {
    PrestamoResponse solicitarPrestamo(PrestamoRequest prestamoRequest);

    InformacionPrestamo obtenerInformacionPrestamo(int id);
}
