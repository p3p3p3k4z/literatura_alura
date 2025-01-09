package com.libros.alura.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Autor {
    private String name;
    private int birth_year;
    private Integer death_year; // Usamos Integer para permitir valores null

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birth_year;
    }

    public void setBirthYear(int birthYear) {
        this.birth_year = birthYear;
    }

    public Integer getDeathYear() {
        return death_year;
    }

    public void setDeathYear(Integer deathYear) {
        this.death_year = deathYear;
    }

    public boolean isAliveInYear(int year) {
        return (birth_year <= year) && (death_year == null || death_year > year);
    }

    @Override
    public String toString() {
        return "Autor{" +
                "name='" + name + '\'' +
                ", birthYear=" + birth_year +
                (death_year != null ? ", deathYear=" + death_year : "") +
                '}';
    }

}
