package com.libros.alura.servicio;

import java.net.URI;
import java.net.http.HttpRequest;

public class SolicitudAPI {
    private static final String BASE_URL = "https://gutendex.com/books/";

    /**
     * Construye una solicitud GET para la API de Gutendex.
     * @param parametros Parámetros de consulta.
     * @return Objeto HttpRequest listo para ser enviado.
     */

    public HttpRequest construirSolicitud(String parametros) {
        String url = BASE_URL + (parametros != null && !parametros.isEmpty() ? "?" + parametros : "");
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
    }
}
