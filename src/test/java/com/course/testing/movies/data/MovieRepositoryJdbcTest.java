package com.course.testing.movies.data;

import com.course.testing.movies.model.Genre;
import com.course.testing.movies.model.Movie;
import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MovieRepositoryJdbcTest {

    private MovieRepository repository;
    private DataSource source;
    private JdbcTemplate template;

    @Before
    public void setUp() throws SQLException {
        source = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        template = new JdbcTemplate(source);
        ScriptUtils.executeSqlScript(source.getConnection(), new ClassPathResource("test-db.sql"));
        repository = new MovieRepositoryJdbc(template);
    }

    @Test
    public void load_all_movies() {
        Collection<Movie> movies = repository.findAll();
        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION, "director1"),
                new Movie(2, "Memento", 113, Genre.THRILLER, "director2"),
                new Movie(3, "Matrix", 136, Genre.ACTION, "director3")
        )));
    }

    @Test
    public void find_movie_by_id() {
        Movie movie = repository.findById(1);
        assertThat(
                movie, is(new Movie(1, "Dark Knight", 152, Genre.ACTION, "director1"))
        );
    }

    @Test
    public void insert_movie() {
        Movie movie = new Movie("Super 8", 110, Genre.THRILLER, "director3");
        repository.saveOrUpdate(movie);

        Movie movieSaved = repository.findById(4);

        assertThat(movieSaved, is(new Movie(4, "Super 8", 110, Genre.THRILLER,"director3")));
    }

    @After
    public void tearDowm() throws SQLException {
        final Statement s = source.getConnection().createStatement();
        s.execute("DROP ALL objects DELETE files");
    }


}