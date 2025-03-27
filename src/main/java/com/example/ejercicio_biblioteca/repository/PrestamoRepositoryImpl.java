package com.example.ejercicio_biblioteca.repository;


import com.example.ejercicio_biblioteca.constantes.SqlContans;
import com.example.ejercicio_biblioteca.dto.InformacionPrestamo;
import com.example.ejercicio_biblioteca.dto.PrestamoResponse;
import com.example.ejercicio_biblioteca.repository.interfaces.PrestamoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


@Repository
public class PrestamoRepositoryImpl implements PrestamoRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public PrestamoResponse solicitarPrestamo(InformacionPrestamo informacionPrestamo) {
        PrestamosEntity entity = new PrestamosEntity(null, informacionPrestamo.getIsbn(),
                informacionPrestamo.getIdentificacionUsuario(), informacionPrestamo.getTipoUsuario(), informacionPrestamo.getFechaMaximaDevolucion());
        em.persist(entity);
        PrestamoResponse response = new PrestamoResponse();
        response.setId(entity.getID());
        response.setFechaMaximaDevolucion(informacionPrestamo.getFechaMaximaDevolucion().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()); //TODO se quema de ejemplo para verificar que el servicio retorne lo esperado.

        return response;
    }

    @Override
    public InformacionPrestamo obtenerInformacionPrestamo(int id) {
        PrestamosEntity prestamo = em.find(PrestamosEntity.class, id);

        return new InformacionPrestamo(
                prestamo.getID(),
                prestamo.getISBN(),
                prestamo.getIDENTIFICATIONNUMBER(),
                prestamo.getTIPOUSUARIO(),
                prestamo.getFECHAMAXIMADEVOLUCION()
        );
    }

    @Override
    public LocalDate obtenerUltimaFechaPorCliente(String cliente) {
        Query q = em.createNativeQuery(SqlContans.CONSULTAR_FECHA);
        q.setParameter("identificacionUsuario", cliente);
        Date result = (Date) q.getSingleResult();
        if (result == null) {
            return LocalDate.now().minusDays(1);
        } else {
            return result.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }

    }
}
