package testing;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class LoginClass {
    List<List<String>> database;

    @BeforeAll
    public void setUp ()
    {
        database = null;
    }
    @Given("I have the following users in the database")
    public void iHaveTheFollowingUsersInTheDatabase(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

        database = dataTable.asLists(String.class);


    }
    @When("I enter {string} and  {string}")
    public void iEnterAnd(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions

        for (List<String> i : database)
        {

        }
        throw new io.cucumber.java.PendingException();
    }
    @Then("Login is invalid")
    public void loginIsInvalid() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
