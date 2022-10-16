package testing;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class LoginClass {
    static List<List<String>> database;

    /*
    *
    *
    *
    @BeforeAll
    public static void setUp ()
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
    * */
//    @Given("the database has the following users")
//    public void theDatabaseHasTheFollowingUsers(io.cucumber.datatable.DataTable dataTable) {
//
//        database = dataTable.asLists();
//    }
//    @Given("I press login")
//    public void iPressLogin1() {
//        // Write code here that turns the phrase above into concrete actions
//
//    }
//    @When("I enter {string} and {string}")
//    public void iEnterAnd1(String string, String string2) {
//        // Write code here that turns the phrase above into concrete actions
//        for (List<String> i : database)
//        {
//
//        }
//    }
//    @Then("login is successful.")
//    public void loginIsSuccessful() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//
//
//    @Given("I press login")
//    public void iPressLogin() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @When("I enter {string} and {string}")
//    public void iEnterAnd(String string, String string2) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("login is unsuccessful")
//    public void loginIsUnsuccessful() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }



}
