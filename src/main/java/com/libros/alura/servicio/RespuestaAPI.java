package com.libros.alura.servicio;

import java.io.IOException;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class RespuestaAPI {

    /**
     * Procesa la respuesta HTTP recibida.
     * @param response Respuesta HTTP de la API.
     * @return Un objeto JSON que representa los datos de la respuesta.
     * @throws IOException Si ocurre un error al procesar el cuerpo de la respuesta.
     */
    public JsonObject procesarRespuesta(HttpResponse<String> response) throws IOException {
        int codigoEstado = response.statusCode();

        if (codigoEstado == 200) {
            // Deserializar el cuerpo JSON
            return JsonParser.parseString(response.body()).getAsJsonObject();
        } else {
            throw new IOException("Error en la solicitud: Código de estado " + codigoEstado);
        }
    }
}
