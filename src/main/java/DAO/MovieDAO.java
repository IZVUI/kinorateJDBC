package DAO;

import Model.Mark;
import Model.Movie.*;
import Model.User.Customer;
import Model.User.Role;
import Model.User.Status;
import Service.UserService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MovieDAO extends DAO {

    private static MovieDAO instance;


    public static MovieDAO getInstance() throws ClassNotFoundException {
        if(instance == null)
            instance = new MovieDAO();
        return instance;
    }

    private MovieDAO() throws ClassNotFoundException {
        super();
    }

    public Film getFilmById(int id) {
        try {
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM movie WHERE id="+id + " AND category=\"FILM\"");

            if(rs.next()) {
                Film film = new Film();

                film.setId(rs.getInt("Id"));
                film.setName(rs.getString("movie_name"));
                film.setDescription(rs.getNString("movie_description"));
                film.setStyle(Style.valueOf(rs.getString("style")));
                film.setRate(rs.getFloat("rate"));
                film.setTime(rs.getInt("film_time"));
                film.setCategory(Category.FILM);

                return film;
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Series getSeriesById(int id) {
        try {
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM series WHERE id="+id);

            if(rs.next()) {
                Series series = new Series();

                series.setId(rs.getInt("Id"));
                series.setName(rs.getString("movie_name"));
                series.setDescription(rs.getNString("movie_description"));
                series.setStyle(Style.valueOf(rs.getString("style")));
                series.setRate(rs.getFloat("rate"));
                series.setSeasons(rs.getInt("seasons"));
                series.setEpisodes(rs.getInt("episodes"));
                series.setPerEpisodeTime(rs.getInt("episodes_time"));

                series.setCategory(Category.SERIES);

                return series;
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public boolean insertFilm(Film film) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO movie" +
                    "(movie_name, movie_description, rate, style, film_time, category)" +
                    " VALUES (?,?,?,?,?,?)");

            ps.setString(1, film.getName());
            ps.setNString(2, film.getDescription());
            ps.setFloat(3, film.getRate());
            ps.setString(4, film.getStyle().toString());
            ps.setInt(5, film.getTime());
            ps.setString(6, Category.FILM.name());

            return ps.executeUpdate() == 1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public boolean updateFilm(Film film) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE movie SET movie_name=?, " +
                    "movie_description=?, rate=?, style=?, film_time=? WHERE Id=" + film.getId());

            ps.setString(1, film.getName());
            ps.setNString(2, film.getDescription());
            ps.setFloat(3, film.getRate());
            ps.setString(4, film.getStyle().toString());
            ps.setInt(5, film.getTime());

            return ps.executeUpdate() == 1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


    public boolean insertSeries(Series series) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO movie" +
                    "(movie_name, movie_description, rate, style, seasons, episodes, episodes_time, category)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, series.getName());
            ps.setNString(2, series.getDescription());
            ps.setFloat(3, series.getRate());
            ps.setString(4, series.getStyle().toString());
            ps.setInt(5, series.getSeasons());
            ps.setInt(6, series.getEpisodes());
            ps.setInt(7, series.getPerEpisodeTime());
            ps.setString(8, Category.SERIES.name());

            return ps.executeUpdate() == 1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public boolean updateSeries(Series series) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE movie SET movie_name=?, " +
                    "movie_description=?, rate=?, style=?, seasons=?, episodes=?, episodes_time=? " +
                    "WHERE Id=" + series.getId());

            ps.setString(1, series.getName());
            ps.setNString(2, series.getDescription());
            ps.setFloat(3, series.getRate());
            ps.setString(4, series.getStyle().toString());
            ps.setInt(5, series.getSeasons());
            ps.setInt(6, series.getEpisodes());
            ps.setInt(7, series.getPerEpisodeTime());

            return ps.executeUpdate() == 1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean addMark(Mark mark) {
        try {
            PreparedStatement ps = connection
                    .prepareStatement("INSERT INTO marks_list(movie_id, user_id, mark) VALUES (?, ?, ?)");

            ps.setInt(1, mark.getMovie().getId());
            ps.setInt(2 , mark.getCustomer().getId());
            ps.setFloat(3 , mark.getMark());

            return ps.executeUpdate() == 1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }




    public ArrayList<Mark> getMarks(Movie movie) {
        try {
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM marks_list WHERE movie_id="+movie.getId());

            ArrayList<Mark> marks = new ArrayList<>();

            while (rs.next()) {
                Customer customer = UserService.getInstance().getCustomerFromDB(rs.getInt("user_id"));
                marks.add(new Mark(customer, movie, rs.getFloat("mark")));
            }

            return marks;

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return new ArrayList<>();
    }


    private Customer extractCustomerFromSet(ResultSet rs) throws SQLException {
        Customer customer = new Customer();

        customer.setId(rs.getInt("Id"));
        customer.setRate(rs.getFloat("rate"));
        customer.setStatus(Status.valueOf(rs.getString("user_status")));
        customer.setAge(rs.getInt("age"));
        customer.setName(rs.getString("first_name"));
        customer.setSurname(rs.getString("surname"));
        customer.setRole(Role.CUSTOMER);

        return customer;
    }

}
