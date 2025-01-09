package com.libros.alura.servicio;

import com.libros.alura.modelo.Autor;
import com.libros.alura.repositorio.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> listarAutoresVivosEnAno(int ano) {
        if (ano <= 0) {
            throw new IllegalArgumentException("El año debe ser un número positivo.");
        }
        return autorRepository.findAutoresVivosEnAno(ano);
    }
}
