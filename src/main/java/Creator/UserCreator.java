package Creator;

import Model.User.Admin;
import Model.User.Customer;

public class UserCreator {

    private static int idCounter = 1;

    public Admin createAdmin(String name, String surname, int age){
        Admin newAdmin = new Admin(name, surname, age);
        newAdmin.setId(idCounter++);
        return newAdmin;
    }

    public Customer createCustomer(String name, String surname, int age){
        Customer newCustomer = new Customer(name, surname, age);
        newCustomer.setId(idCounter++);
        return newCustomer;
    }

}
