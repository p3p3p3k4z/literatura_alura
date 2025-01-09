package com.libros.alura.servicio;

import com.libros.alura.modelo.Autor;
import com.libros.alura.modelo.Libro;
import com.libros.alura.repositorio.AutorRepository;
import com.libros.alura.repositorio.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibroService {

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;

    public LibroService(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public Libro guardarLibroConAutor(Libro libro) {
        Autor autor = libro.getAutor();
        if (autor.getId() == null) {
            autor = autorRepository.save(autor); // Guarda al autor si no existe
        }
        libro.setAutor(autor);
        return libroRepository.save(libro);
    }
}
