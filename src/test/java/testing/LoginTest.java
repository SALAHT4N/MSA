package testing;


import com.software.mas.model.LoginModel;
import com.software.mas.model.templates.LoginStatus;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginTest {

    LoginStatus out;
    LoginModel model;

    @Given("I enter login page")
    public void i_enter_login_page() {

        model = new LoginModel();
    }
    @When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_enter_and(String email, String password) {
        // Write code here that turns the phrase above into concrete actions
        try {
           out = model.authenticate(email, password);
        }catch(Exception e){
            e.printStackTrace();
            return;
        }

    }
    @Then("^login is \"([^\"]*)\" and user level is \"([^\"]*)\"$")
    public void login_is_and_user_level_is(String output, String level) {
        // Write code here that turns the phrase above into concrete actions
        int lvl = Integer.parseInt(level);
        boolean correct = Boolean.parseBoolean(output);

        Assert.assertEquals(out.getLvl(),lvl);
        Assert.assertEquals(out.isCorrect(),correct);

    }

}
