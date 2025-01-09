package com.libros.alura.repositorio;

import com.libros.alura.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    // Contar libros por idioma usando una consulta derivada
    long countByLanguagesContaining(String idioma);

    // Alternativa: Usar una consulta personalizada si necesitas más flexibilidad
    @Query("SELECT COUNT(l) FROM Libro l WHERE :idioma MEMBER OF l.languages")
    long contarLibrosPorIdioma(@Param("idioma") String idioma);
}
