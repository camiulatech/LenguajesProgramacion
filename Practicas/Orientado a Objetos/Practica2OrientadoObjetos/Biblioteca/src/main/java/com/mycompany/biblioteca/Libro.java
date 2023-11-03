package com.mycompany.biblioteca;

import java.util.List;

class Libro {
    private int codigo;
    private String titulo;
    private String autor;
    private boolean disponible;

    public Libro(int codigo, String titulo, String autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    public boolean estaDisponible() {
        return this.disponible;
    }

    public void prestamo() {
        this.disponible = false;
    }

    public void devolver() {
        this.disponible = true;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getTitulo() {
        return this.titulo;
    }
    
    public static void mostrarEstadoLibros(List<Libro> libros) {
        System.out.println("Estado de los libros en la biblioteca:");
        for (Libro libro : libros) {
            String disponibilidad = libro.estaDisponible() ? "Disponible" : "No disponible";
            System.out.println("Libro: " + libro.getTitulo() + " - Estado: " + disponibilidad);
        }
    }
}

