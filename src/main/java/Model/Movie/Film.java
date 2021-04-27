package Model.Movie;

public class Film extends Movie {

    private int time;


    public Film(String name, String description, Style style) {
        super(name, description, style);
        setCategory(Category.FILM);
    }

    public Film(String name, String description, Style style, int time) {
        super(name, description, style);
        setCategory(Category.FILM);
        setTime(time);
    }

    public Film() {
        super();
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return super.toString()
                +"\nTime: "+getTime();
    }
}
