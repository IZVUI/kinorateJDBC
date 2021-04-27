package ServiceTest;

import Model.Mark;
import Model.Movie.Film;
import Model.Movie.Movie;
import Model.Movie.Series;
import Model.Movie.Style;
import Model.User.Customer;
import Service.MovieService;
import Service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public class MovieServiceTest {
    MovieService ms;

    @Before
    public void setUp() {
        ms = MovieService.getInstance();
    }

    @Test
    public void creteFilm() {
        Movie movie = ms.createFilm("Name", "Deeeeeeeessssssscriiiiiptiiioioioin", Style.ACTION, 120);

        Assert.assertNotNull(movie);
    }

    @Test
    public void createSeries() {
        Movie movie = ms.createSeries("NameSeries", "dasdadasdasdasdas", Style.ACTION,
                3, 15, 45);

        Assert.assertNotNull(movie);
    }

    @Test
    public void addFilmToBase() {
        Movie movie = ms.createFilm("Name", "Deeeeeeeessssssscriiiiiptiiioioioin", Style.ACTION, 120);

        boolean isAdded = ms.addFilmToBase((Film) movie);

        Assert.assertTrue(isAdded);
    }

    @Test
    public void addSeriesToBase() {
        Movie movie = ms.createSeries("NameSeries", "dasdadasdasdasdas", Style.ACTION,
                3, 15, 45);

        boolean isAdded = ms.addSeriesToBase((Series) movie);

        Assert.assertTrue(isAdded);
    }

    @Test
    public void rateMovie() {
        Movie movie = ms.getFilmById(1);

        Customer cust = new Customer();
        try {
             cust = UserService.getInstance().getCustomerFromDB(1);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        ms.rateMovie(movie, cust, 4);


    }

    @Test
    public void getFilmById() {
        Film filmNull = ms.getFilmById(2);
        Film film = ms.getFilmById(1);

        Assert.assertTrue(filmNull == null && film != null);
    }

    @Test
    public void getMarks() {
        Film film = ms.getFilmById(1);

        ArrayList<Mark> marks = ms.getMarks(film);

        Assert.assertEquals(marks.size(), 3);
    }
}
