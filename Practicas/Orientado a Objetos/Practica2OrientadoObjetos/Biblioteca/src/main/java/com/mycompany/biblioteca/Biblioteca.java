package com.mycompany.biblioteca;

import static com.mycompany.biblioteca.Libro.mostrarEstadoLibros;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {

    public static void main(String[] args) {
        Socio socio1 = new Socio(1, "Jorge", "San Joaquin, Heredia");
        Socio socio2 = new Socio(2, "Vanessa", "Belen, Heredia");
        Socio socio3 = new Socio(3, "Denia", "La Garita, Alajuela");
        
        Libro libro1 = new Libro(1, "Romeo y Julieta", "William Shakespeare");
        Libro libro2 = new Libro(2, "Cien años de soledad", "Gabriel García Márquez");
        Libro libro3 = new Libro(3, "Don Quijote de la Mancha", "Miguel de Cervantes");
        Libro libro4 = new Libro(4, "El Principito", "Antoine de Saint-Exupéry");
        Libro libro5 = new Libro(5, "El león, la bruja y el armario", "C.S. Lewis");
        Libro libro6 = new Libro(6, "El caballo y el muchacho" , "C.S. Lewis");
        Libro libro7 = new Libro(7, "Becoming" , "Michelle Obama");

        
        List<Socio> socios = new ArrayList<>();
        socios.add(socio1);
        socios.add(socio2);
        socios.add(socio3);
        
        List<Libro> libros = new ArrayList<>();
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        libros.add(libro4);
        libros.add(libro5);
        libros.add(libro6);
        libros.add(libro7);
        
        // Ejemplos se socios tomando libros prestados y su devolucion
        System.out.println("Ejemplos de tomar prestado y devolver");
        socio1.tomarPrestado(libro3);
        socio2.tomarPrestado(libro7);
        socio2.tomarPrestado(libro4);
        socio3.tomarPrestado(libro5);
        socio3.tomarPrestado(libro6);
        socio3.tomarPrestado(libro2);
        socio3.tomarPrestado(libro1);
  
        socio1.devolver(libro3);
        socio2.devolver(libro7);
            
        // Ejemplo para mostrar el estado de todos los libros
        System.out.println("\n");
        mostrarEstadoLibros(libros);

        List<Socio> sociosConMasDeTresLibros = filtrarSociosConMasDeTresLibros(socios);
        
       // Ejemplo de socios que tengan mas de 3 libros prestados
        System.out.println(" \nSocios con más de 3 libros prestados:");
        for (Socio socio : sociosConMasDeTresLibros) {
            System.out.println(socio.getNombre());
        }
    }

        public static List<Socio> filtrarSociosConMasDeTresLibros(List<Socio> socios) {
            return socios.stream().filter(s -> s.contarLibrosPrestados() > 3).collect(Collectors.toList());
        }

}

