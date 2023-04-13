package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtilities;

import java.sql.SQLException;

public class DB_US_161_SD {
    @Then("user verifies that if the each client exists")
    public void userVerifiesThatIfTheEachClientExists() throws SQLException {
        while (DBUtilities.resultSet.next()) {
            String clientId = DBUtilities.resultSet.getString("client_id");
            System.out.println(clientId);
            Assert.assertNotNull(clientId);
        }
    }
}
