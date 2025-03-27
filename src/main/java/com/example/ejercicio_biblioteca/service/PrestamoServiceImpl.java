package com.example.ejercicio_biblioteca.service;

import com.example.ejercicio_biblioteca.constantes.UsuariosConstans;
import com.example.ejercicio_biblioteca.dto.InformacionPrestamo;
import com.example.ejercicio_biblioteca.dto.PrestamoRequest;
import com.example.ejercicio_biblioteca.dto.PrestamoResponse;
import com.example.ejercicio_biblioteca.excepciones.PretamoExcepcion;
import com.example.ejercicio_biblioteca.repository.interfaces.PrestamoRepository;
import com.example.ejercicio_biblioteca.service.interfaces.PrestamoService;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoRepository prestamoRepository;

    public PrestamoServiceImpl(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    @Override
    public PrestamoResponse solicitarPrestamo(PrestamoRequest prestamoRequest) {
        InformacionPrestamo informacionPrestamo = new InformacionPrestamo();
        informacionPrestamo.setIsbn(prestamoRequest.getIsbn());
        informacionPrestamo.setIdentificacionUsuario(prestamoRequest.getIdentificacionUsuario());
        informacionPrestamo.setTipoUsuario(validarUsuario(prestamoRequest.getTipoUsuario()));
        informacionPrestamo.setFechaMaximaDevolucion(addDaysSkippingWeekends(LocalDate.now(), sumarDiasPorUsuario(prestamoRequest.getTipoUsuario())));

        LocalDate fechaUltimoPrestamo = prestamoRepository.obtenerUltimaFechaPorCliente(prestamoRequest.getIdentificacionUsuario());

        validarFechaPrestamo(fechaUltimoPrestamo, prestamoRequest.getTipoUsuario() , prestamoRequest.getIdentificacionUsuario());

        return prestamoRepository.solicitarPrestamo(informacionPrestamo);

    }

    @Override
    public InformacionPrestamo obtenerInformacionPrestamo(int id) {
        return prestamoRepository.obtenerInformacionPrestamo(id);
    }

    private void validarFechaPrestamo(LocalDate fechaBase, Integer usuario, String identificacion) {
        if (fechaBase.isAfter(LocalDate.now()) && usuario == 3) {
            throw new PretamoExcepcion("El usuario con identificación " + identificacion + " ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo");
        }
    }

    private static Date addDaysSkippingWeekends(LocalDate fechaHoy, Integer sumarDias) {
        LocalDate result = fechaHoy;
        int addedDays = 0;
        while (addedDays < sumarDias) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }

        return Date.from(result.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    private Integer validarUsuario(Integer usuario) {
        if (usuario <= 0 || usuario >= 4) {
            throw new PretamoExcepcion("Tipo de usuario no permitido en la biblioteca");
        } else {
            return usuario;
        }
    }

    private Integer sumarDiasPorUsuario(Integer usuario) {
        int resultado = 0;

        switch (usuario) {
            case UsuariosConstans.USUARIO_AFILIADO:
                resultado = UsuariosConstans.DIAS_USUARIO_AFILIADO;
                break;
            case UsuariosConstans.USUARIO_EMPLEADO:
                resultado = UsuariosConstans.DIAS_USUARIO_EMPLEADO;
                break;
            case UsuariosConstans.USUARIO_INVITADO:
                resultado = UsuariosConstans.DIAS_USUARIO_INVITADO;
                break;
        }
        return resultado;

    }
}
