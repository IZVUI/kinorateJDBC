package ServiceTest;

import Model.Movie.Movie;
import Model.Review;
import Model.User.Customer;
import Service.MovieService;
import Service.ReviewService;
import Service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class ReviewServiceTest {

    ReviewService rs;

    @Before
    public void setUp() {
        rs = ReviewService.getInstance();
    }

    @Test
    public void createReview() {
        Review review = null;
        try {
            Customer customer = UserService.getInstance().getCustomerFromDB(1);
            Movie movie = MovieService.getInstance().getFilmById(1);

            review = rs.createReview(customer, movie, "LALALLALALLALALALALLA");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(review);
    }

    @Test
    public void getReview() {
        Review review = rs.getReviewById(1);

        Assert.assertNotNull(review);
    }
}
