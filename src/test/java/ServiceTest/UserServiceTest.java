package ServiceTest;

import Model.Mark;
import Model.User.Customer;
import Model.User.Status;
import Service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserServiceTest {

    UserService us;

    @Before
    public void setUp() throws ClassNotFoundException {
        us = UserService.getInstance();
    }

    @Test
    public void userCreate() {


        Customer customer = us.createCustomer("Name", "Surname", 16);

        Assert.assertNotNull(customer);
    }

    @Test
    public void addToDB() {


        Customer customer = us.createCustomer("Name3", "Surname3", 23);

        boolean isAdded = us.addCustomerToBase(customer);

        Assert.assertTrue(isAdded);
    }

    @Test
    public void increaseRate()  {
        Customer customer = null;
        float before = 0;
        try {
            customer = us.getCustomerFromDB(1);
            before = customer.getRate();
            us.increaseCustomerRate(customer, 0.2f);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Assert.assertTrue((before + 0.2f) == customer.getRate());
    }

    @Test
    public void banCustomer() {
        Customer customer = null;
        float before = 0;
        try {
            customer = us.getCustomerFromDB(1);
            us.banCustomer(customer);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Assert.assertTrue(customer.getStatus() == Status.BANNED);
    }

    @Test
    public void unbanCustomer() {
        Customer customer = null;
        float before = 0;
        try {
            customer = us.getCustomerFromDB(1);
            us.unbanCustomer(customer);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Assert.assertTrue(customer.getStatus() == Status.ACTIVE);
    }

    @Test
    public void getMarks() {
        Customer customer = null;
        try {
            customer = us.getCustomerFromDB(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        ArrayList<Mark> marks = us.getMarks(customer);

        Assert.assertEquals(marks.size(), 3);
    }
}
