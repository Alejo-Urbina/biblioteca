package com.example.ejercicio_biblioteca.constantes;

public class SqlContans {

    public static final String CONSULTAR_INORMACION_PRESTAMOS_POR_ID_PRESTAMOS = "SELECT ID, ISBN, IDENTIFICACIONUSUARIO, TIPOUSUARIO, FECHAMAXIMADEVOLUCION from prestamos where ID = :id";
    public static final String INSERTAR_PRESTAMO=  " INSERT INTO prestamos "
            + " (ID, ISBN, IDENTIFICACIONUSUARIO, TIPOUSUARIO, FECHAMAXIMADEVOLUCION) "
            + " VALUES (PRESTAMOS_SEQ.nextval, :isbn, :identificacionUsuario, :tipoUsuario, :fechaMaximaDevolucion)";

    public static final String CONSULTAR_FECHA="SELECT MAX(FECHAMAXIMADEVOLUCION) FROM prestamos WHERE IDENTIFICACIONUSUARIO = :identificacionUsuario";

}
