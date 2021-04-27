package Model.Movie;

public class Series extends Movie {

    private int seasons;
    private int episodes;
    private int perEpisodeTime;

    public Series(String name, String description, Style style) {
        super(name, description, style);
        setCategory(Category.SERIES);
    }
    public Series(String name, String description, Style style, int seasons, int episodes, int perEpisodeTime) {
        super(name, description, style);
        setCategory(Category.SERIES);
        setSeasons(seasons);
        setEpisodes(episodes);
        setPerEpisodeTime(perEpisodeTime);
    }

    public Series() {
        super();
    }


    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public int getPerEpisodeTime() {
        return perEpisodeTime;
    }

    public void setPerEpisodeTime(int perEpisodeTime) {
        this.perEpisodeTime = perEpisodeTime;
    }

    @Override
    public String toString() {
        return super.toString()
                +"\nSeasons: "+getSeasons()
                +"\nSeries: "+ getEpisodes()
                +"\nPer episode time" + getPerEpisodeTime();
    }
}
