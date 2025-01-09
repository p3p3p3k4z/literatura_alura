package com.libros.alura;

import com.libros.alura.modelo.Autor;
import com.libros.alura.modelo.Libro;
import com.libros.alura.servicio.ConseguirAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ConseguirAPI api = new ConseguirAPI();
    private static final List<Libro> catalogoLibros = new ArrayList<>();

    public static void main(String[] args) {

        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    buscarLibroPorTitulo();
                    break;
                case "2":
                    mostrarCatalogoLibros();
                    break;
                case "3":
                    filtrarLibrosPorIdioma();
                    break;
                case "4":
                    listarAutores();
                    break;
                case "5":
                    listarAutoresVivosEnAno();
                    break;
                case "0":
                    continuar = false;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n=== Menú de Opciones ===");
        System.out.println("1. Buscar libro por título");
        System.out.println("2. Ver todos los libros en el catálogo");
        System.out.println("3. Filtrar libros por idioma");
        System.out.println("4. Listar autores");
        System.out.println("5. Listar autores vivos en un año");
        System.out.println("0. Salir");
    }

    private static void buscarLibroPorTitulo() {
        System.out.print("Ingresa el título del libro: ");
        String titulo = scanner.nextLine();

        List<Libro> resultados = api.obtenerDatos("search=" + titulo);

        if (resultados != null && !resultados.isEmpty()) {
            Libro libro = resultados.get(0); // Tomar el primer resultado
            if (!libro.getLanguages().isEmpty()) {
                libro.setLanguages(List.of(libro.getLanguages().get(0))); // Quedarse con el primer idioma
            }
            if (!libro.getAuthors().isEmpty()) {
                libro.setAuthors(List.of(libro.getAuthors().get(0))); // Quedarse con el primer autor
            }
            catalogoLibros.add(libro);

            System.out.println("\nLibro encontrado:");
            System.out.println("Título: " + libro.getTitle());
            Autor autor = libro.getAuthors().get(0);
            System.out.println("Autor: " + autor.getName() +
                    " (Nacido: " + autor.getBirthYear() +
                    ", Fallecido: " + (autor.getDeathYear() != null ? autor.getDeathYear() : "Vivo") + ")");
            System.out.println("Idioma: " + libro.getLanguages().get(0));
            System.out.println("Descargas: " + libro.getDownloadCount());
        } else {
            System.out.println("No se encontró ningún libro con el título: " + titulo);
        }
    }

    private static void mostrarCatalogoLibros() {
        if (catalogoLibros.isEmpty()) {
            System.out.println("El catálogo está vacío.");
            return;
        }

        System.out.println("\n=== Catálogo de Libros ===");
        catalogoLibros.forEach(libro -> {
            System.out.println("Título: " + libro.getTitle());
            System.out.println("Autor(es): " + libro.getAuthors().stream().map(a -> a.getName()).toList());
            System.out.println("Idioma: " + libro.getLanguages().get(0));
            System.out.println("Descargas: " + libro.getDownloadCount());
            System.out.println("--------------------------");
        });
    }

    private static void filtrarLibrosPorIdioma() {
        if (catalogoLibros.isEmpty()) {
            System.out.println("El catálogo está vacío. No hay libros para filtrar.");
            return;
        }

        System.out.print("Ingresa el idioma para filtrar (ejemplo: 'en' para inglés, 'es' para español): ");
        String idioma = scanner.nextLine();

        List<Libro> librosFiltrados = catalogoLibros.stream()
                .filter(libro -> libro.getLanguages().get(0).equalsIgnoreCase(idioma))
                .toList();

        if (librosFiltrados.isEmpty()) {
            System.out.println("No se encontraron libros en el idioma: " + idioma);
        } else {
            System.out.println("\n=== Libros en el idioma: " + idioma + " ===");
            librosFiltrados.forEach(libro -> {
                System.out.println("Título: " + libro.getTitle());
                System.out.println("Autor(es): " + libro.getAuthors().stream().map(a -> a.getName()).toList());
                System.out.println("Idioma: " + libro.getLanguages().get(0));
                System.out.println("Descargas: " + libro.getDownloadCount());
                System.out.println("--------------------------");
            });
        }
    }

    private static void listarAutores() {
        if (catalogoLibros.isEmpty()) {
            System.out.println("No hay autores para listar.");
            return;
        }

        System.out.println("\n=== Lista de Autores ===");
        catalogoLibros.forEach(libro -> {
            Autor autor = libro.getAuthors().get(0);
            System.out.println("Nombre: " + autor.getName() +
                    " (Nacido: " + autor.getBirthYear() +
                    ", Fallecido: " + (autor.getDeathYear() != null ? autor.getDeathYear() : "Vivo") + ")");
        });
    }

    private static void listarAutoresVivosEnAno() {
        System.out.print("Ingresa el año para buscar autores vivos: ");
        try {
            int ano = Integer.parseInt(scanner.nextLine());

            List<Autor> autoresVivos = catalogoLibros.stream()
                    .map(libro -> libro.getAuthors().get(0))
                    .filter(autor -> autor.getBirthYear() <= ano &&
                            (autor.getDeathYear() == null || autor.getDeathYear() > ano))
                    .toList();

            if (autoresVivos.isEmpty()) {
                System.out.println("No se encontraron autores vivos en el año: " + ano);
            } else {
                System.out.println("\n=== Autores vivos en el año " + ano + " ===");
                autoresVivos.forEach(autor -> {
                    System.out.println("Nombre: " + autor.getName() +
                            " (Nacido: " + autor.getBirthYear() +
                            ", Fallecido: " + (autor.getDeathYear() != null ? autor.getDeathYear() : "Vivo") + ")");
                });
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Por favor, ingresa un número entero para el año.");
        }
    }

}
