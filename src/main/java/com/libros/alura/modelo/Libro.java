package com.libros.alura.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignora campos desconocidos como "id"
public class Libro {
    private String title;

    @JsonProperty("publication_date")
    private String publicationDate;

    private List<String> languages;

    private List<String> subjects;

    private List<Autor> authors;

    private int downloadCount;

    // Constructor por defecto
    public Libro() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<Autor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Autor> authors) {
        this.authors = authors;
    }

    public String getPrimaryLanguage() {
        return (languages != null && !languages.isEmpty()) ? languages.get(0) : "Desconocido";
    }

    public Autor getPrimaryAuthor() {
        return (authors != null && !authors.isEmpty()) ? authors.get(0) : null;
    }

    public boolean isWrittenInLanguage(String language) {
        return languages != null && languages.contains(language);
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "title='" + title + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                ", primaryLanguage='" + getPrimaryLanguage() + '\'' +
                ", subjects=" + subjects +
                ", primaryAuthor=" + getPrimaryAuthor() +
                '}';
    }

}
