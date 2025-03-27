package com.example.ejercicio_biblioteca.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/prestamo")
public class PrestamoControlador {

//    private final PrestamoService prestamoService;
//
//    public PrestamoControlador(PrestamoService prestamoService) {
//        this.prestamoService = prestamoService;
//    }
//
//    @PostMapping()
//    public final PrestamoResponse solicitarPrestamo(@RequestBody PrestamoRequest prestamoRequest) {
//        return prestamoService.solicitarPrestamo(prestamoRequest);
//    }
//
//    @GetMapping("/{id-prestamo}")
//    public final InformacionPrestamo obtenerInformacionPrestamo(@PathVariable("id-prestamo") int id) {
//        System.out.println("ingreso al get");
//        return prestamoService.obtenerInformacionPrestamo(id);
//    }
}

