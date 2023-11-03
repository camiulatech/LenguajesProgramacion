package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Socio {
    private int numeroSocio;
    private String nombre;
    private String direccion;
    private List<Prestamo> prestamos;

    public Socio(int numeroSocio, String nombre, String direccion) {
        this.numeroSocio = numeroSocio;
        this.nombre = nombre;
        this.direccion = direccion;
        this.prestamos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
    

    public void tomarPrestado(Libro libro) {
        if (libro.estaDisponible()) {
            this.prestamos.add(new Prestamo(libro.getCodigo(), this.numeroSocio, new Date()));
            libro.prestamo();
            System.out.println(this.nombre + " ha tomado prestado el libro " + libro.getTitulo() + ".");
        } else {
            System.out.println("El libro " + libro.getTitulo() + " no está disponible.");
        }
    }

    public void devolver(Libro libro) {
        Prestamo prestamo = encontrarPrestamo(libro.getCodigo());
        if (prestamo != null) {
            this.prestamos.remove(prestamo);
            libro.devolver();
            System.out.println(this.nombre + " ha devuelto el libro " + libro.getTitulo() + ".");
        } else {
            System.out.println(this.nombre + " no tiene prestado el libro " + libro.getTitulo() + ".");
        }
    }

    public int contarLibrosPrestados() {
        return this.prestamos.size();
    }

    private Prestamo encontrarPrestamo(int codigoLibro) {
        for (Prestamo prestamo : this.prestamos) {
            if (prestamo.getCodigoLibro() == codigoLibro) {
                return prestamo;
            }
        }
        return null;
    }
}