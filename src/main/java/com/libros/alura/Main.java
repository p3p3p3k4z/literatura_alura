package com.libros.alura;

import com.libros.alura.modelo.Libro;
import com.libros.alura.servicio.ConseguirAPI;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConseguirAPI api = new ConseguirAPI();

        // Buscar libros relacionados con Tolkien
        List<Libro> libros = api.obtenerDatos("search=tolkien");

        if (libros != null) {
            libros.forEach(libro -> {
                System.out.println("Título: " + libro.getTitle());
                System.out.println("Autor(es): " + libro.getAuthors().stream().map(a -> a.getName()).toList());
                System.out.println("Idiomas: " + libro.getLanguages());
                System.out.println("Temas: " + libro.getSubjects());
                System.out.println("--------------------------");
            });
        } else {
            System.out.println("No se encontraron libros.");
        }
    }
}
