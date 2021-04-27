package Model;

import Model.Movie.Movie;
import Model.User.User;

public class Review {
    private int id;
    private Movie movie;
    private User user;
    private String text;

    public Review(String text, Movie movie, User user){
        setText(text);
        setUser(user);
        setMovie(movie);
    }

    public Review() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id == 0)
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "User: " + getUser().getName() + " " + getUser().getSurname()
                +"\nMovie: " + getMovie().getName()
                +"Text: " + getText();
    }
}
