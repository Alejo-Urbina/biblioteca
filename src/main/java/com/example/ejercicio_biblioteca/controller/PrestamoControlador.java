package com.example.ejercicio_biblioteca.controller;

import com.example.ejercicio_biblioteca.dto.InformacionPrestamo;
import com.example.ejercicio_biblioteca.dto.PrestamoRequest;
import com.example.ejercicio_biblioteca.dto.PrestamoResponse;
import com.example.ejercicio_biblioteca.service.interfaces.PrestamoService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/prestamo")
public class PrestamoControlador {

    private final PrestamoService prestamoService;

    public PrestamoControlador(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @PostMapping()
    public final PrestamoResponse solicitarPrestamo(@RequestBody PrestamoRequest prestamoRequest) {
        System.out.println("Hola mundo");
        return prestamoService.solicitarPrestamo(prestamoRequest);
    }

    @GetMapping("/{id-prestamo}")
    public final InformacionPrestamo obtenerInformacionPrestamo(@PathVariable("id-prestamo") int id) {
        System.out.println("ingreso al get");
        return prestamoService.obtenerInformacionPrestamo(id);
    }
}

