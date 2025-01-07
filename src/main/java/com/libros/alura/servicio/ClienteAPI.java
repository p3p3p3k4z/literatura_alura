package com.libros.alura.servicio;

import java.net.http.HttpClient;

public class ClienteAPI {
    private final HttpClient cliente;

    public ClienteAPI() {
        // Crear una instancia del cliente HTTP
        this.cliente = HttpClient.newHttpClient();
    }

    public HttpClient getCliente() {
        return cliente;
    }
}