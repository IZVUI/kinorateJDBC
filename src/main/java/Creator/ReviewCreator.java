package Creator;

import Model.Movie.Movie;
import Model.Review;
import Model.User.User;

public class ReviewCreator {
    public static int idCounter = 1;

    public Review createReview(String text, Movie movie, User user){
        Review newReview = new Review(text, movie, user);
        newReview.setId(idCounter++);
        return newReview;
    }
}
