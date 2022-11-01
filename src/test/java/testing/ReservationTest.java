package testing;

import com.software.mas.model.ReserveModel;
import com.software.mas.model.templates.AppointmentsData;
import com.software.mas.model.templates.BooksData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class ReservationTest {
    ReserveModel model;
    String userEmail;
   
    @Given("^a \"([^\"]*)\" click reserve now$")
    public void a_click_reserve_now(String user) {
        // Write code here that turns the phrase above into concrete actions
        userEmail = user;
        model= new ReserveModel();
    }

    @Then("^all available appointments will shown up of the \"([^\"]*)\"$")
    public void allAvailableAppointmentsWillShownUpOfThe(String service) {
        List<AppointmentsData> availableAppointments = model.getAllAvailable(service);
        //This data will be shown on a table.
    }

    //@param2 time -> START-END-DAY formatted
    @And("^pressed on book option of a specific \"([^\"]*)\" at specific \"([^\"]*)\"$")
    public void pressed_on_book_option_of_a_specific_at_specific(String service, String time) throws SQLException {
        // Write code here that turns the phrase above into concrete actions
        model.reserve(userEmail,service,time);
    }

    @Then("^the user will have an appointment at the \"([^\"]*)\" in the \"([^\"]*)\"$")
    public void the_will_have_an_appointment_at_the_in_the( String expectedTime, String expectedService) throws SQLException {
        // Write code here that turns the phrase above into concrete actions
       List<BooksData> reservedApp = model.getUserReservedAppointments(userEmail);

        for (BooksData e : reservedApp) {
            String[] times = expectedTime.split("~");
            LocalDateTime time1 = LocalDateTime.parse(times[0]);
            LocalDateTime time2 = LocalDateTime.parse(times[1]);


            if(Objects.equals(expectedService, e.serviceId()) && e.startAt().equals(time1) && e.endAt().equals(time2) ){
                Assert.assertEquals(1,1);
                return;
            }
        }

        Assert.assertEquals(1,0);
    }


}
