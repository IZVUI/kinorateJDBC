package Service;

import DAO.ReviewDAO;
import Model.Movie.Movie;
import Model.Review;
import Model.User.Customer;
import Model.User.User;

import java.sql.SQLException;

public class ReviewService {

    ReviewDAO dao;
    private static ReviewService instance;

    public static ReviewService getInstance() {
        if(instance == null)
            instance = new ReviewService();
        return instance;
    }


    private ReviewService() {
        try {
            dao = new ReviewDAO();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Review createReview(Customer customer, Movie movie, String text) {
        Review newReview = new Review(text, movie, customer);

        addToBase(newReview);

        return newReview;
    }

    public Review getReviewById(int id) {
        try {
            return dao.getReviewById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public boolean addToBase(Review review) {
        return dao.insertReview(review);
    }



}
