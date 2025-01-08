package com.libros.alura.servicio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.libros.alura.modelo.Libro;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

public class RespuestaAPI {

    /**
     * Procesa la respuesta HTTP y convierte el cuerpo en una lista de objetos Libro.
     *
     * @param httpResponse La respuesta HTTP obtenida de la API.
     * @return Lista de libros obtenidos de la respuesta JSON.
     */
    public List<Libro> procesarRespuesta(HttpResponse<String> httpResponse) {
        try {
            // Crear un ObjectMapper para procesar el JSON
            ObjectMapper objectMapper = new ObjectMapper();

            // Leer el nodo principal "results"
            var rootNode = objectMapper.readTree(httpResponse.body());
            var resultsNode = rootNode.get("results");

            // Convertir el nodo "results" en una lista de objetos Libro
            return objectMapper.readValue(
                    resultsNode.toString(), // Convertimos el nodo en una cadena JSON
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Libro.class)
            );
        } catch (IOException e) {
            System.err.println("Error al procesar la respuesta JSON: " + e.getMessage());
            return null;
        }
    }
}
