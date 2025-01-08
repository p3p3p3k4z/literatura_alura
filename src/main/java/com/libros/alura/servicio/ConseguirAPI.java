package com.libros.alura.servicio;

import com.libros.alura.modelo.Libro;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

public class ConseguirAPI {
    private final ClienteAPI cliente;
    private final SolicitudAPI solicitud;
    private final RespuestaAPI respuesta;

    public ConseguirAPI() {
        this.cliente = new ClienteAPI();
        this.solicitud = new SolicitudAPI();
        this.respuesta = new RespuestaAPI();
    }

    /**
     * Realiza una solicitud GET a la API de Gutendex y obtiene una lista de libros.
     *
     * @param parametros Parámetros de consulta (ejemplo: "search=tolkien").
     * @return Lista de libros.
     */
    public List<Libro> obtenerDatos(String parametros) {
        try {
            var request = solicitud.construirSolicitud(parametros);
            HttpResponse<String> httpResponse = cliente.getCliente().send(request, HttpResponse.BodyHandlers.ofString());
            return respuesta.procesarRespuesta(httpResponse);
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al realizar la solicitud: " + e.getMessage());
            return null;
        }
    }
}
