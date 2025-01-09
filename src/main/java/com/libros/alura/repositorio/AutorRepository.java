package com.libros.alura.repositorio;

import com.libros.alura.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    // Derived query para encontrar autores vivos en un año determinado
    List<Autor> findByBirthYearLessThanEqualAndDeathYearGreaterThanEqual(int year1, int year2);

    // Alternativa: Consulta personalizada para manejar más casos
    @Query("SELECT a FROM Autor a WHERE a.birthYear <= :year AND (a.deathYear IS NULL OR a.deathYear >= :year)")
    List<Autor> findAutoresVivosEnAno(@Param("year") int year);
}
