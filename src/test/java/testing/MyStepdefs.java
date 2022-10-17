package testing;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {

    @Before()
    public void connect(){
        System.out.println("Connecting to DB and REMOTE SERVER");
    }

    @Given("X has {int} on a row")
    public void x_has_on_a_row(Integer int1) {
        System.out.println("Make a request to the server and insert the ...");

    }
    @When("X play {int} on a row")
    public void x_play_on_a_row(Integer int1) {
        System.out.println("Response that the operation succeed");


    }
    @Then("X wins true")
    public void x_wins_true() {
        System.out.println("Some assertion ");


    }
    @After()
    public void disconnecting(){
        System.out.println("Disconnecting ...");

    }
}
