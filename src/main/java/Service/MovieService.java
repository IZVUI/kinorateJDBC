package Service;

import DAO.MovieDAO;
import Model.Mark;
import Model.Movie.Film;
import Model.Movie.Movie;
import Model.Movie.Series;
import Model.Movie.Style;
import Model.User.Customer;
import Model.User.Status;
import Model.User.User;

import java.util.ArrayList;

public class MovieService {

    public static MovieService instance;

    MovieDAO dao;


    public static MovieService getInstance() {
        if(instance == null)
            instance = new MovieService();
        return instance;
    }

    private MovieService() {
        try {
            dao = MovieDAO.getInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Mark> getMarks(Movie movie) {
        return dao.getMarks(movie);
    }

    public void rateMovie(Movie movie, Customer customer, float rate) {
        ArrayList<Mark> marks = getMarks(movie);
        float totalRate = movie.getRate() * marks.size();
        movie.setRate((totalRate + rate) / marks.size());

        addMark(new Mark(customer, movie, rate));

        if(movie.getClass() == Film.class)
            dao.updateFilm((Film) movie);
        else dao.updateSeries((Series) movie);
        ///maybe add logic of auto increment customer rate
    }

    private void addMark(Mark mark) {
        dao.addMark(mark);
    }

    private void autoCustomerRate(Movie movie) throws ClassNotFoundException {///////////////!!!!!!!!!!!!
        UserService us = UserService.getInstance();
        for (Mark mark: dao.getMarks(movie)
             ) {
            float markValue = mark.getMark();
            if(markValue <= movie.getRate() + 0.3f
            && markValue >= movie.getRate() - 0.3f)
                us.increaseCustomerRate(mark.getCustomer(), 0.1f);
            else us.increaseCustomerRate(mark.getCustomer(), -0.1f);
        }
    }

    public Film createFilm(String name, String description, Style style, int time) {
        Film newFilm = new Film(name, description, style, time);
        //add newFilm to DB
        addFilmToBase(newFilm);
        return  newFilm;
    }

    public boolean addFilmToBase(Film film) {
        return dao.insertFilm(film);
    }

    public Series createSeries(String name, String description, Style style
            , int seasons, int episodes, int perEpisodeTime ) {
        Series newSeries = new Series(name, description, style, seasons, episodes, perEpisodeTime);
        //add newSeries to DB
        addSeriesToBase(newSeries);
        return newSeries;
    }

    public boolean addSeriesToBase(Series series) {
        return dao.insertSeries(series);
    }

    //get movies bu params


    public Film getFilmById(int id) {
        return dao.getFilmById(id);
    }

    public Series getSeriesById(int id) {
        return dao.getSeriesById(id);
    }

}
