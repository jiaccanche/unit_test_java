package com.course.testing.movies.model;

import java.util.Objects;

public class Movie {

    private Integer id;
    private String name;
    private int minutes;
    private Genre genre;
    private String director;

    public Movie(String name, int minutes, Genre genre, String director) {
        this(null, name, minutes, genre, director);
    }

    public Movie(Integer id, String name, int minutes, Genre genre, String director) {
        this.id = id;
        this.name = name;
        this.minutes = minutes;
        this.genre = genre;
        this.director = director;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMinutes() {
        return minutes;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return minutes == movie.minutes && Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && genre == movie.genre && director == movie.director;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, minutes, genre, director);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
