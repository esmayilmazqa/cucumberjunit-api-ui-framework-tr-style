package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.SchedulingCalendar;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.List;

public class US_086_SD {
    SchedulingCalendar sc = new SchedulingCalendar();
    WebDriver driver = Driver.getDriver();

    @Given("the user is on {string} page")
    public void theUserIsOnPage(String url) {

        //driver.get(ConfigurationReader.getPropertyFromProperties("environment")+url);
        //is page load?
        WebElement controlBtn = sc.blockTimeBtn;
        BrowserUtilities.waitForClickablility(controlBtn, 15);
    }

    @Then("the user verifies if cell of the current day is in different color")
    public void theUserVerifiesIfCellOfTheCurrentDayIsInDifferentColor() {
        WebElement todayCell = sc.todayDateCell;
        Assert.assertTrue(todayCell.isDisplayed());


    }

    @When("the user select today date")
    public void theUserSelectTodayDate() {
        BrowserUtilities.scrollToElement(sc.todayDateCell);
        sc.todayDateCell.click();
        WebElement submitButton = sc.submmitBtn;
        BrowserUtilities.waitForClickablility(submitButton, 3);
    }

    @Then("the user verifies Book an appoinment section appears")
    public void theUserVerifiesBookAnAppoinmentSectionAppears() {
        WebElement appointmentPopup = sc.appointmentPopup;
        Assert.assertTrue(appointmentPopup.isDisplayed());
    }

    @Then("the user verifies if Select Service Type is Registered Services")
    public void theUserVerifiesIfSelectServiceIsSelected() {
        WebElement radioRegisService = sc.radioRegisService;
        Assert.assertTrue(radioRegisService.isSelected());

    }

    @When("the user clicks on Service dropdown on Registered Services")
    public void theUserClicksOnServiceDropdownOnRegisteredServices() {
        WebElement serviceDropdown = sc.serviceDropdown;
        serviceDropdown.click();
        BrowserUtilities.waitFor(1);

    }

    @Then("the user verifies if all items of dropdowm are there and selectable")
    public void theUserVerifiesIfAllServicesAreThere() {
        List<WebElement> items = sc.comboboxElements;
        for (WebElement item : items) {
            //System.out.println(service.getText());
            Assert.assertTrue(item != null);
        }
        BrowserUtilities.clickWithJS(items.get(items.size()-1));
    }

    @When("the user clicks on Location dropdown on Registered Services")
    public void theUserClicksOnLocationDropdownOnRegisteredServices() {
        WebElement locationCombobox = sc.locationDropdown;
        locationCombobox.click();
        BrowserUtilities.waitFor(1);

    }


}
