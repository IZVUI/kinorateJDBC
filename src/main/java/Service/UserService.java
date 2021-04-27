package Service;

import DAO.MovieDAO;
import DAO.UserDAO;
import Model.Mark;
import Model.User.Customer;
import Model.User.Status;
import org.w3c.dom.UserDataHandler;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserService {

    private static UserService instance;
    UserDAO dao;


    public static UserService getInstance() throws ClassNotFoundException {
        if(instance == null)
            instance = new UserService();
        return instance;
    }

    private UserService() {
        try {
            dao = UserDAO.getInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void banCustomer(Customer customer) {
        customer.setStatus(Status.BANNED);
        // add update in db
        boolean id = dao.updateCustomer(customer);
        if(id){

        }
    }

    public void unbanCustomer(Customer customer) {
        customer.setStatus(Status.ACTIVE);
        // add update in db
        dao.updateCustomer(customer);
    }

    public ArrayList<Mark> getMarks(Customer customer) {
        return dao.getMarks(customer);
    }

    public Customer getCustomerFromDB(int id) throws SQLException {
        return dao.getCustomerById(id);
    }

    public void increaseCustomerRate(Customer customer, float increment){
        customer.setRate(customer.getRate() + increment);
        // update in db
        dao.updateCustomer(customer);
    }

    public Customer createCustomer(String name, String surname, int age) {
        Customer newCustomer = new Customer(name, surname, age);

        addCustomerToBase(newCustomer);

        return newCustomer;
    }

    public boolean addCustomerToBase(Customer customer) {
        return dao.insertCustomer(customer);
    }

    //get users by params
}
