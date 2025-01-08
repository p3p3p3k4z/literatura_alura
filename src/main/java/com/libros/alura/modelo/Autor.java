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

    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    public Integer getDeath_year() {
        return death_year;
    }

    public void setDeath_year(Integer death_year) {
        this.death_year = death_year;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "name='" + name + '\'' +
                ", birthYear=" + birth_year +
                '}';
    }
}
