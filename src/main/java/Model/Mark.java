package Model;

import Model.Movie.Movie;
import Model.User.Customer;

public class Mark {
    private Customer customer;
    private Movie movie;
    private float mark;

    public Mark(Customer customer, Movie movie, float mark) {
        setCustomer(customer);
        setMark(mark);
        setMovie(movie);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }
}
