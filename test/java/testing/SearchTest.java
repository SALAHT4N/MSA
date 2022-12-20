package testing;

import com.software.mas.model.HomeModel;
import com.software.mas.model.templates.HomeCard;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.SQLException;
import java.util.Queue;

public class SearchTest {
    HomeModel home;
    Queue<HomeCard> data;
    @Given("i entered the home page")
    public void i_entered_the_home_page() {
        //Model init
        home = new HomeModel();
    }
    @When("^i search for \"([^\"]*)\", and located in \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void i_search_for_and_located_in(String street, String city, String country, String tags) throws SQLException {
        //Getting data from the database
        data = home.searchFor(street,city,country,tags,false);

    }
    @Then("^the output will be \"([^\"]*)\"$")
    public void the_output_will_be(String id) {
        //Check using Asserting
        String[] arrId = id.split(",");

        for(String test : arrId){
            Assert.assertEquals(test,String.valueOf(data.poll().id()));
        }
    }


}
