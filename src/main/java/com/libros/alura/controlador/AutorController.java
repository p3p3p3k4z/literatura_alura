package com.libros.alura.controlador;

import com.libros.alura.modelo.Autor;
import com.libros.alura.servicio.AutorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping("/autores/vivos")
    public List<Autor> obtenerAutoresVivosEnAno(@RequestParam int ano) {
        return autorService.listarAutoresVivosEnAno(ano);
    }
}
