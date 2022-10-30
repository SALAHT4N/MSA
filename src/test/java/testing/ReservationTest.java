package testing;

import com.software.mas.model.ReserveModel;
import com.software.mas.model.templates.AppointmentsData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

public class ReservationTest {
    ReserveModel model;
    String userEmail;
    String serviceId;
    String time;
    @Given("^a \"([^\"]*)\" click reserve now$")
    public void a_click_reserve_now(String user) {
        // Write code here that turns the phrase above into concrete actions
        user=userEmail;
        model= new ReserveModel();
    }

    @Then("^all available appointments will shown up of the \"([^\"]*)\"$")
    public void allAvailableAppointmentsWillShownUpOfThe(String service) {
        List<AppointmentsData> availableAppointments = model.getAllAvailable(service);
        //This data will be shown on a table.
    }

    //@param2 time -> START-END-DAY formatted
    @And("^pressed on book option of a specific \"([^\"]*)\" at specific \"([^\"]*)\"$")
    public void pressed_on_book_option_of_a_specific_at_specific(String service, String time) {
        // Write code here that turns the phrase above into concrete actions
        model.reserve(userEmail,service,time);
    }

    @Then("^the user will have an appointment at the \"([^\"]*)\" in the \"([^\"]*)\"$")
    public void the_will_have_an_appointment_at_the_in_the( String expectedService, String expectedTime) {
        // Write code here that turns the phrase above into concrete actions

       List<AppointmentsData> reservedApp = model.getUserReservedAppointments(userEmail);

    }


}
