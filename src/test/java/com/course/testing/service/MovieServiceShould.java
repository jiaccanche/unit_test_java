package com.course.testing.service;

import com.course.testing.movies.data.MovieRepository;
import com.course.testing.movies.model.Genre;
import com.course.testing.movies.model.Movie;
import com.course.testing.movies.service.MovieService;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertThat;

public class MovieServiceShould {

    private MovieService movieService;

    @Before
    public void setUp() throws Exception {

        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION, "director1"),
                        new Movie(2, "Memento", 113, Genre.THRILLER,"director1"),
                        new Movie(3, "There's Something About Mary", 119, Genre.COMEDY,"director1"),
                        new Movie(4, "Super 8", 112, Genre.THRILLER,"director6"),
                        new Movie(5, "SuperMan ", 112, Genre.ACTION,"director5"),
                        new Movie(6, "Scream", 111, Genre.HORROR,"director4"),
                        new Movie(7, "Home Alone", 103, Genre.COMEDY,"director2"),
                        new Movie(8, "Matrix", 136, Genre.ACTION,"director3")
                )
        );

        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {

        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(3, 7)) );
    }

    @Test
    public void return_movies_by_length() {

        Collection<Movie> movies = movieService.findMoviesByLength(119);
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(2, 3, 4, 5, 6, 7)) );
    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }

    @Test
    public void return_movies_by_name(){
        Collection<Movie> movies = movieService.findMoviesByName("Super");
        assertThat(
                getMovieIds(movies),
                CoreMatchers.is(Arrays.asList(4,5))
        );
    }

    @Test
    public void return_movies_by_director(){
        Collection<Movie> movies = movieService.findMoviesByDirector("director1");
        assertThat(
                getMovieIds(movies),
                CoreMatchers.is(Arrays.asList(1,2,3))
        );
    }
}