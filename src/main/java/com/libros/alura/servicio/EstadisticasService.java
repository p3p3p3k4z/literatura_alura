package com.libros.alura.servicio;

import com.libros.alura.repositorio.LibroRepository;
import org.springframework.stereotype.Service;

@Service
public class EstadisticasService {

    private final LibroRepository libroRepository;

    public EstadisticasService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public long obtenerCantidadDeLibrosPorIdioma(String idioma) {
        return libroRepository.countByLanguagesContaining(idioma);
    }

    public void mostrarEstadisticas() {
        // Ejemplo para dos idiomas: inglés y español
        String idioma1 = "English";
        String idioma2 = "Spanish";

        long librosEnIngles = obtenerCantidadDeLibrosPorIdioma(idioma1);
        long librosEnEspanol = obtenerCantidadDeLibrosPorIdioma(idioma2);

        System.out.println("Estadísticas de Libros:");
        System.out.println("Libros en inglés: " + librosEnIngles);
        System.out.println("Libros en español: " + librosEnEspanol);
    }
}
