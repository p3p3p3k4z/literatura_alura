package com.libros.alura.controlador;

import com.libros.alura.servicio.EstadisticasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstadisticasController {

    private final EstadisticasService estadisticasService;

    public EstadisticasController(EstadisticasService estadisticasService) {
        this.estadisticasService = estadisticasService;
    }

    @GetMapping("/estadisticas/idioma")
    public String obtenerEstadisticasPorIdioma(@RequestParam String idioma) {
        long cantidad = estadisticasService.obtenerCantidadDeLibrosPorIdioma(idioma);
        return "Cantidad de libros en " + idioma + ": " + cantidad;
    }
}
