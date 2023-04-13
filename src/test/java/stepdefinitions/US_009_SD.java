package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.List;

public class US_009_SD {
    HomePage hp = new HomePage();

    @Then("User verifies if testimonials section appears")
    public void userVerifiesIfTestimonialsSectionAppears() {
        BrowserUtilities.scrollToElement(hp.testimonialTitle);
        WebElement testimonial = hp.testimonialSlider;
        Assert.assertTrue(testimonial.isDisplayed());

    }

    // pay attention : testimonials - visible da hata var ama clickable da yok
    @Then("User verifies if accounts of the relevant persons are visible")
    public void userVerifiesIfAccountsOfTheRelevantPersonsAreVisible() {
        List<WebElement> accountsOfPerson = hp.socialLinksInTestimonial;

        WebElement arrow = hp.rightArrow;
        for (WebElement element : accountsOfPerson) {
            BrowserUtilities.waitForVisibility(element, 2);
            Assert.assertTrue("account is not visible", element.isDisplayed());
            if (arrow.isEnabled())
                BrowserUtilities.clickWithJS(arrow);
        }
        Driver.closeDriver();
    }

    @Then("User verifies if social buttons is clickable")
    public void userVerifiesIfSocialButtonsIsClickable() {
        List<WebElement> btnListOfSocial = hp.socialLinksInTestimonial;
        for (WebElement element : btnListOfSocial) {
            Assert.assertTrue(element.isEnabled());
        }
    }

    @When("User clicks on each social button")
    public void userClicksOnEachSocialButton() {
        List<WebElement> btnListOfSocial = hp.socialLinksInTestimonial;
        for (WebElement element : btnListOfSocial) {
            BrowserUtilities.clickWithJS(element);
        }
    }

    @Then("User verifies if the relevant pages open")
    public void userVerifiesIfTheRelevantPagesOpen() {
        List<String> urls = BrowserUtilities.getAllWindowsUrls();
        for (String url : urls) {
            Assert.assertNotEquals(ConfigurationReader.getPropertyFromProperties("url"), url);
        }
        Driver.closeDriver();
    }

    @Then("User verifies if left arrow is disabled at the begin of testimonial")
    public void userVerifiesIfLeftArrowIsDisabledAtTheBeginOfTestimonial() {
        BrowserUtilities.scrollToElement(hp.testimonialSlider);
        WebElement previousArrow = hp.leftArrow;
        Assert.assertFalse(previousArrow.isEnabled());
    }

    @Then("User verifies if right arrow is disabled at the end of the testimonial")
    public void userVerifiesIfRightArrowIsDisabledAtTheEndOfTheTestimonial() {
        WebElement nextArrow = hp.rightArrow;
        List<WebElement> control = hp.controlofPeople;
        while (true) {
            if (nextArrow.isEnabled()) {
                //nextArrow.click(); - element click intercepted: Element is not clickable at point (1524, 3676)
                BrowserUtilities.clickWithJS(nextArrow);
            } else {
                Assert.assertTrue(control.size() == 1);
                break;
            }
        }
    }

    @Then("User verifies if right arrow and left arrow is enabled at the middle of the testimonial")
    public void userVerifiesIfRightArrowAndLeftArrowIsEnabledAtTheMiddleOfTheTestimonial() {
        WebElement previousArrow = hp.leftArrow;
        WebElement nextArrow = hp.rightArrow;

        if (previousArrow.isEnabled()) {
            BrowserUtilities.clickWithJS(previousArrow);
        } else if (nextArrow.isEnabled()) {
            nextArrow.click();
        }
        List<WebElement> control = hp.controlofPeople;
        Assert.assertTrue(control.size() != 1);

    }
}
