package Model.Movie;

import Model.Mark;
import Model.User.Customer;

import java.util.ArrayList;
import java.util.List;

public abstract class Movie implements IMovie {
    private int id;
    private String name;
    private String description;
    private float rate;
    private Style style;
    private Category category;

//// add ratedList to DB
    public Movie(String name, String description, Style style){
        setName(name);
        setDescription(description);
        setStyle(style);
    }

    public Movie() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(this.id == 0)
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object obj) {
        obj = (Movie)obj;
        return this.getId() == ((Movie) obj).getId();
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Name: " + getName()
                +"\nStyle: " + getStyle()
                +"\nRate: " + getRate()
                +"\nDescription: "+getDescription()
                +"\nCategory: "+getCategory();
    }
}
