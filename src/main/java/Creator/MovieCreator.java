package Creator;

import Model.Movie.Film;
import Model.Movie.Series;
import Model.Movie.Style;

public class MovieCreator {

    private static int idCounter = 1;

    public Film createFilm(String name, String description, Style style, int time){
        Film newFilm = new Film(name, description, style, time);
        newFilm.setId(idCounter++);
        return newFilm;
    }

    public Series createSeries(String name, String description, Style style,
                               int seasons, int episodes, int perEpisodeTime) {
        Series newSeries = new Series(name, description, style, seasons, episodes, perEpisodeTime);
        newSeries.setId(idCounter++);
        return newSeries;
    }
}
