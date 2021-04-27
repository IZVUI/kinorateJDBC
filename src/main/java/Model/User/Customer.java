package Model.User;

import Model.Movie.Movie;

import java.util.HashMap;

public class Customer extends User {

    private float rate;
    private Status status;
    private HashMap<Movie,Float> votedMovies;

    public Customer(String name, String surname, int age) {
        super(name, surname, age);
        setRate(0);
        setStatus(Status.ACTIVE);
        setRole(Role.CUSTOMER);
        setVotedMovies(new HashMap<>());
    }

    public Customer() {

    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public HashMap<Movie, Float> getVotedMovies() {
        return votedMovies;
    }

    public void setVotedMovies(HashMap<Movie, Float> votedMovies) {
        this.votedMovies = votedMovies;
    }

    @Override
    public String toString() {
        return super.toString()
                +"Status: " + getStatus()
                +"Rate: " + getRate();
    }
}
