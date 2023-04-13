package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.SchedulingCalendar;
import utilities.BrowserUtilities;
import utilities.Driver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class US_098_SD_SeeTheAppoinment {
    String appointInfo = "";
    SchedulingCalendar sc = new SchedulingCalendar();

    @When("the user clicks on any appointment on the calendar")
    public void theUserClicksOnAnyAppointmentOnTheCalendar() {
        WebElement anyCell = sc.anyAppoinCell;
        BrowserUtilities.waitForClickablility(anyCell, 3);

        appointInfo = anyCell.findElement(sc.anyAppoinCellNameInfo).getText();
        String date = anyCell.findElement(sc.anyAppoinCellMain).getAttribute("data-date");
        appointInfo += "," + date;
        anyCell.click();
    }

    @Then("the user verifies if Meet Info field appears")
    public void theUserVerifiesIfMeetInfoFieldAppears() {
        System.out.println(appointInfo);//name,date -> green snail,2022-06-03
        BrowserUtilities.waitForClickablility(sc.googleBtn, 4);
        Assert.assertTrue(sc.meetInfoForm.isDisplayed());

    }

    @Then("the user verifies if {string} button is clickable")
    public void theUserVerifiesIfButtonIsClickable(String text) {
        if (text.equals("Google")) {
            Assert.assertTrue(sc.googleBtn.isEnabled());
        } else if (text.equals("Outlook")) {
            Assert.assertTrue(sc.outlookBtn.isEnabled());
        } else if (text.equals("Go to Meeting")) {
            for (WebElement btns : sc.goToMeetingBtns) {
                Assert.assertTrue(btns.isEnabled());
            }
        }
    }

    @When("the user clicks on {string} button to see on Calendar")
    public void theUserClicksOnButtonToSeeOnCalendar(String text) {
        if (text.equals("Google")) {
            BrowserUtilities.clickWithJS(sc.googleBtn);
        } else if (text.equals("Outlook")) {
            sc.outlookBtn.click();
        }

    }

    @Then("the user verifies if {string} calendar page opens")
    public void theUserVerifiesIfCalendarPageOpens(String text) {
        String childUrl = BrowserUtilities.getChildWindowURL();
        Assert.assertTrue(childUrl.contains(text.toLowerCase()));
    }


    @Then("the user verifies Mark as options are functional")
    public void theUserVerifiesMarkAsOptionsAreFunctional() {
        List<WebElement> radioBtns = sc.radioBtnsInMeetInfo;
        for (WebElement rBtn : radioBtns) {
            Assert.assertTrue(rBtn.isEnabled());
            rBtn.click();
            BrowserUtilities.waitFor(1);
        }

    }

    @Then("the user verifies if the info of Meeting is correct")
    public void theUserVerifiesIfTheInfoOfMeetingIsCorrect() {
        String[] dates = appointInfo.split(",")[1].split("-");
        Assert.assertTrue(sc.dateMeetInfo.getText().contains(dates[0]));
        Assert.assertTrue(sc.dateMeetInfo.getText().contains(dates[2]));
    }

    @When("the user clicks on Meeting Url button")
    public void theUserClicksOnMeetingUrlButton() {
        sc.goToMeetingBtns.get(0).click();
    }

    @Then("the user verifies if Meeting screen opens")
    public void theUserVerifiesIfMeetingScreenOpens() {
        String childUrl =BrowserUtilities.getChildWindowURL();
        Assert.assertTrue(childUrl.contains("https://meet.hypnotes.net/"));
    }


}
