package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.RefundSchedulingPage;
import utilities.BrowserUtilities;
import utilities.Driver;

import java.util.List;

public class US_117_SD {
    RefundSchedulingPage rsp = new RefundSchedulingPage();

    @Then("the user verifies if {string} is visible")
    public void theUserVerifiesIfIsVisible(String text) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//*[text()='" + text + "']"));
        Assert.assertTrue(element.isDisplayed());
    }

    @Then("the user verifies Cancel an Appointment button is visible")
    public void theUserVerifiesCancelAnAppointmentButtonIsVisible() {
        WebElement cancelAppBtn = rsp.cancelAppBtn;
        Assert.assertTrue(cancelAppBtn.isDisplayed());
    }

    @When("the user clicks on Cancel an Appointment button")
    public void theUserClicksOnCancelAnAppointmentButton() {
        BrowserUtilities.waitForClickablility(rsp.cancelAppBtn, 9);
        rsp.cancelAppBtn.click();
    }

    @Then("the user verifies if Cancellation dropdowns are visible")
    public void theUserVerifiesIfCancellationDropdownsAreVisible() {
        BrowserUtilities.waitFor(2);
        Assert.assertTrue(rsp.cancelFeeDrop.isDisplayed());
        Assert.assertTrue(rsp.cancelHoursLimitDrop.isDisplayed());

    }


    @Then("the user verifies if Default value of dropdowns are correct")
    public void theUserVerifiesIfDefaultValueOfDropdownsAreCorrect() {
        Assert.assertTrue(Integer.parseInt(rsp.cancelFeeDrop.getAttribute("value"))!=0);
        Assert.assertTrue(Integer.parseInt(rsp.cancelHoursLimitDrop.getAttribute("value"))!=0);
    }

    @Then("the user verifies if Up down buttons of Cancellation dropdowns are functional")
    public void theUserVerifiesIfUpDownButtonsOfCancellationDropdownsAreFunctional() {
        BrowserUtilities.waitForClickablility(rsp.saveBtn, 9);
        Actions act = new Actions(Driver.getDriver());
        for (int i = 0; i < 3; i++) {
            act.moveToElement(rsp.cancelHoursLimitDrop).click(rsp.cancelHoursLimitDrop).sendKeys(Keys.ARROW_UP).build().perform();
        }
        for (int i = 0; i < 3; i++) {
            act.moveToElement(rsp.cancelFeeDrop).click().sendKeys(Keys.ARROW_UP).build().perform();
        }
        Assert.assertTrue(Integer.parseInt(rsp.cancelHoursLimitDrop.getAttribute("value")) > 24);
        Assert.assertTrue(Integer.parseInt(rsp.cancelFeeDrop.getAttribute("value")) > 4);
    }

    @Then("the user verifies if necessary symbol is display")
    public void theUserVerifiesIfNecessarySymbolIsDisplay() {
        WebElement element = rsp.symbolDrop;
        BrowserUtilities.waitForClickablility(element,3);
        element.click();
        BrowserUtilities.waitFor(1);
        List<WebElement> symbols = rsp.symbols;
        symbols.get(1).click();
        Assert.assertTrue(element.getText().equals("$"));
    }

    @When("the user clicks on Save button on Refund Section")
    public void theUserClicksOnSaveButtonOnRefundSection() {
        rsp.saveBtn.click();
    }

    @Then("the user verifies if {string} message is display")
    public void theUserVerifiesIfMessageIsDisplay(String message) {
        BrowserUtilities.waitForVisibility(rsp.successMessage,4);
        System.out.println(rsp.successMessage.getText());
    }
}
