package DAOTest;


import DAO.ConnectionFactory;
import org.junit.Assert;
import org.junit.Test;

public class ConnectionTest {

    @Test
    public void getConnection() throws ClassNotFoundException {
        Assert.assertNotNull(ConnectionFactory.getConnection());
    }
}
