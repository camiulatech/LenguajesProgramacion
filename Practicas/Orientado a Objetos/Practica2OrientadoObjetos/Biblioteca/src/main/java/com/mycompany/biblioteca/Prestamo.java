package com.mycompany.biblioteca;

import java.util.Date;


class Prestamo {
    private int codigoLibro;
    private int numeroSocio;
    private Date fecha;

    public Prestamo(int codigoLibro, int numeroSocio, Date fecha) {
        this.codigoLibro = codigoLibro;
        this.numeroSocio = numeroSocio;
        this.fecha = fecha;
    }

    public int getCodigoLibro() {
        return this.codigoLibro;
    }
}
