package Model.User;

import Model.Mark;

import java.util.ArrayList;

public abstract class User implements IUser {

    private int id;
    private int age;
    private String name;
    private String surname;
    private Role role;


    public User(String name, String surname, int age) {
        setName(name);
        setSurname(surname);
        setAge(age);
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (this.id == 0)
            this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public boolean equals(Object obj) {
        obj = (User)obj;
        return this.getId() == ((User) obj).getId();
    }

    @Override
    public String toString() {
        return "Name: " + getName()
                +"\nSurname: "+getSurname()
                +"\nAge: "+getAge()
                +"\nRole: "+getRole();
    }
}
