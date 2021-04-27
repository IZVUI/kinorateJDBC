package Model.User;

import Service.MovieService;
import Service.UserService;

public class Admin extends User {


    public Admin(String name, String surname, int age) {
        super(name, surname, age);
        setRole(Role.ADMIN);
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
