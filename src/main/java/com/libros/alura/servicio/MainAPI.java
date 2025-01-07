package com.libros.alura.servicio;

import java.io.IOException;
import java.net.http.HttpResponse;

public class MainAPI {
    private final ClienteAPI cliente;
    private final SolicitudAPI solicitud;
    private final RespuestaAPI respuesta;

    public MainAPI() {
        this.cliente = new ClienteAPI();
        this.solicitud = new SolicitudAPI();
        this.respuesta = new RespuestaAPI();
    }

    /**
     * Realiza una solicitud GET a la API de Gutendex.
     * @param parametros Parámetros de consulta (ejemplo: "search=tolkien").
     * @return Un objeto JSON con la respuesta de la API.
     */

    public JsonObject obtenerDatos(String parametros) {
        try {
            // Construir la solicitud
            var request = solicitud.construirSolicitud(parametros);

            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> httpResponse = cliente.getCliente().send(request, HttpResponse.BodyHandlers.ofString());

            // Procesar y devolver los datos
            return respuesta.procesarRespuesta(httpResponse);
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al realizar la solicitud: " + e.getMessage());
            return null;
        }
    }
}
