package DAO;

import Model.Movie.Category;
import Model.Movie.Film;
import Model.Movie.Movie;
import Model.Movie.Series;
import Model.Review;
import Model.User.Customer;
import Service.MovieService;
import Service.UserService;

import java.sql.*;

public class ReviewDAO extends DAO {
    public ReviewDAO() throws ClassNotFoundException {
        super();
    }

    public Review getReviewById(int id) throws SQLException {
        try {
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM review WHERE id=" + id);

            if(rs.next())
            return extractReviewFromSet(rs);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public boolean insertReview(Review review) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO review(movie_id, user_id, review_text) " +
                    "VALUES (?, ?, ?)");

            ps.setInt(1, review.getMovie().getId());
            ps.setInt(2, review.getUser().getId());
            ps.setNString(3, review.getText());

            return ps.executeUpdate() == 1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


    public Review extractReviewFromSet(ResultSet rs) {
        Review review = new Review();

        try {
            review.setId(rs.getInt("Id"));

            Movie movie = MovieService.getInstance().getFilmById(rs.getInt("movie_id"));

            if (movie == null)
                movie = MovieService.getInstance().getSeriesById(rs.getInt("movie_id"));


            review.setMovie(movie);
            review.setUser(UserService.getInstance().getCustomerFromDB(rs.getInt("user_id")));
            review.setText(rs.getNString("review_text"));
        }
        catch (Exception ex) {
        }



        return review;
    }
}
