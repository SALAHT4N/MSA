package testing;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ReservationTest {

    @Given("^a \"([^\"]*)\" click reserve now$")
    public void a_click_reserve_now(String user) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("all available appointments will shown up")
    public void all_available_appointments_will_shown_up() {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("^pressed on book option of a specific \"([^\"]*)\" at specific \"([^\"]*)\"$")
    public void pressed_on_book_option_of_a_specific_at_specific(String service, String time) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^the \"([^\"]*)\" will have an appointment at the \"([^\"]*)\" in the \"([^\"]*)\"$")
    public void the_will_have_an_appointment_at_the_in_the(String expectedUser, String expectedService, String expectedTime) {
        // Write code here that turns the phrase above into concrete actions
    }

}
