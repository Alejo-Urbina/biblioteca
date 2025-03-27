package com.example.ejercicio_biblioteca.repository.interfaces;


import com.example.ejercicio_biblioteca.dto.InformacionPrestamo;
import com.example.ejercicio_biblioteca.dto.PrestamoResponse;

import java.time.LocalDate;

public interface PrestamoRepository {

    PrestamoResponse solicitarPrestamo(InformacionPrestamo informacionPrestamo);

    InformacionPrestamo obtenerInformacionPrestamo(int id);

    LocalDate obtenerUltimaFechaPorCliente(String cliente) ;

}
