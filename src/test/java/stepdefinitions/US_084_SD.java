package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import pages.SchedulingSettings;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class US_084_SD {
    WebDriver driver = Driver.getDriver();
    SchedulingSettings ss = new SchedulingSettings();

    @Given("the user is on calendar page {string}")
    public void theUserIsOnCalendarPage(String url) {
        String path = ConfigurationReader.getPropertyFromProperties("environment") + url;
        driver.get(path);
        System.out.println("s0");
    }

    @When("the user accepts the cookie")
    public void theUserAcceptsTheCookie() {

        try {

            WebElement acceptButton = ss.acceptCookieButton;
            BrowserUtilities.clickWithJS(acceptButton);

            WebElement closeToolbar = ss.belowSpeedToolbar;
            closeToolbar.click();
        } catch (Exception e) {
            System.out.println("Tiklayamadım");
        }

    }

    @When("the user clicks on {string} button on Scheduling menu")
    public void theUserClicksOnButton(String text) {
        WebElement menu = driver.findElement(By.xpath("//*[text()='" + text + "']"));
        BrowserUtilities.waitForClickablility(menu, 3);
        BrowserUtilities.clickWithJS(menu);
        BrowserUtilities.waitFor(2);
        //System.out.println("s1");
    }

    @Then("the user verifies Flexible Time Button is clickable")
    public void theUserVerifiesFlexibleTimeButtonIsClickable() {
        BrowserUtilities.waitForClickablility(ss.flexibleTimeButton, 3);
        Assert.assertTrue(ss.flexibleTimeButton.isEnabled());
        System.out.println("s2");
    }

    @Then("the user verifies if Customize your url button is clickable")
    public void theUserVerifiesIfCustomizeYourUrlButtonIsClickable() {
        BrowserUtilities.waitForClickablility(ss.customizeYourUrl, 3);
        Assert.assertTrue(ss.customizeYourUrl.isEnabled());
        System.out.println("s3");
    }

    @Then("the user verifies if Add Block Time, Save, Off Day buttons are clickable")
    public void theUserVerifiesIfAddBlockTimeSaveOffDayButtonsAreClickable() {
        Assert.assertTrue(ss.offDayCheckbox.isEnabled());
        BrowserUtilities.waitForClickablility(ss.addBlockTimeButton, 3);
        BrowserUtilities.waitForClickablility(ss.saveButton, 3);
        System.out.println("s4");
        BrowserUtilities.clickWithJS(ss.logoutButton);
        Driver.closeDriver();
        BrowserUtilities.waitFor(1);
    }


    @When("the user clicks on Add Block Time button")
    public void theUserClicksOnAddBlockTimeButton() {
        BrowserUtilities.waitForClickablility(ss.addBlockTimeButton, 5);
        BrowserUtilities.clickWithJS(ss.addBlockTimeButton);
        System.out.println("s5");

    }

    @Then("the user verifies if Day title, Add button and start-end times controls are visible")
    public void theUserVerifiesIfDayTitleAddButtonAndStartEndTimesControlsAreVisible() {
        BrowserUtilities.waitForVisibility(ss.addBlockTimeContainer, 10);
        Assert.assertTrue(ss.dayTitle.isDisplayed());
        Assert.assertTrue(ss.addButtonOnBlockTime.isDisplayed());
        Assert.assertTrue(ss.addCbbStartTime.isEnabled());
        //Assert.assertTrue(ss.addCbbEndTime.isEnabled());
        // ccb in visible olması isDisplayed ile kontrol edilememiz mi?
        // bir de cbb nin içeriğine mi bakıyor. Yani yazı yoksa visible değil mi demek
        // System.out.println(ss.addCbbStartTime.getText()); //bos
        System.out.println("s6");
    }

    @When("the user selects the start and end time") //!!!!!!!!!scrolldown
    public void theUserSelectsTheStartAndEndTime() {
        ss.addCbbStartTime.click(); // javascript tıklayamadı
        BrowserUtilities.waitFor(1);
        //  element icerisinde Scrolldown yapamıyorum.

        List<WebElement> startTimesAdd = ss.addCbbStartTimes;
        /*System.out.println(optionList.size());
       for (WebElement option : optionList) {
            System.out.println(option.getText());
        }*/

        BrowserUtilities.clickWithJS(startTimesAdd.get(5));
        BrowserUtilities.waitFor(2);
        // bundan sonra cbb a tekrar tıklayıp tekrar javascript ile tıklarsan boyle adım adım ilerleyebilirsin

        ss.addCbbEndTime.click();
        List<WebElement> endTimesAdd = ss.addCbbEndTimes;
        BrowserUtilities.clickWithJS(endTimesAdd.get(6));

        System.out.println("s6");
    }

    @And("the user clicks on Add button on Add Block Time popup section")
    public void theUserClicksOnAddButtonOnAddBlockTimePopupSection() {
        BrowserUtilities.waitFor(3);

        BrowserUtilities.waitForClickablility(ss.addButtonOnBlockTime, 3);
        ss.addButtonOnBlockTime.click();
        System.out.println("s7");
    }

    @Then("the user verifies if Blocked Times section display under the section")
    public void theUserVerifiesIfBlockedTimesSectionDisplayUnderTheSection() {

        WebElement blockTimesHeader = ss.blockTimesHeader;
        BrowserUtilities.waitForVisibility(blockTimesHeader, 3);
        Assert.assertTrue(blockTimesHeader.isDisplayed());

        List<WebElement> blockedTimes = ss.blockTimesCbbs;
        Assert.assertTrue(blockedTimes.size() != 0);
        BrowserUtilities.waitFor(3);

        System.out.println("s8");
    }

    @Then("the user verifies if Update and Delete buttons are there")
    public void theUserVerifiesIfUpdateAndDeleteButtonsAreThere() {
        List<WebElement> updateBtns = ss.updateButtons;
        Assert.assertTrue(updateBtns.size() != 0);
        List<WebElement> deleteBtns = ss.deleteButtons;
        Assert.assertTrue(deleteBtns.size() != 0);

        System.out.println("s9");

    }

    @When("the user clicks on Update button")
    public void theUserClicksOnUpdateButton() {
        BrowserUtilities.waitFor(3);
        BrowserUtilities.waitForClickablility(ss.updateButtons.get(0), 3);
        ss.updateButtons.get(0).click();
        BrowserUtilities.waitFor(3);
        System.out.println("s10");
    }

    @Then("the user verifies if the new Update button exists in new popup section")
    public void theUserVerifiesIfTheNewUpdateButtonExistsInNewPopupSection() {
        BrowserUtilities.waitFor(3);
        WebElement updateWindow = ss.updatePopup;
        BrowserUtilities.waitForVisibility(updateWindow, 4);
        Assert.assertTrue(ss.updateButtons.get(0).isDisplayed());
        System.out.println("s11");

        List<WebElement> cbbs = driver.findElements(By.xpath("(//div[contains(@id,'rcDialogTitle')])[7]/../following-sibling::div/div/div/div"));
        BrowserUtilities.waitForClickablility(cbbs.get(0),5);
        cbbs.get(0).click();
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='rc-virtual-list-holder-inner']"));
        System.out.println(items.size());
        System.out.println("*********************");
        BrowserUtilities.clickWithJS(items.get(6));


        BrowserUtilities.waitFor(13);

        // acilan pencereyi kapatmak için (popup)
        Actions act = new Actions(driver);
        act.click(updateWindow).sendKeys(Keys.ESCAPE).build().perform();
        BrowserUtilities.waitFor(3);
    }

    @When("the user clicks on Delete button")
    public void theUserClicksOnDeleteButton() {
        BrowserUtilities.waitForClickablility(ss.deleteButtons.get(0), 4);
        ss.deleteButtons.get(0).click();
        System.out.println("s12");
    }

    @Then("the user verifies if {string}  message display")
    public void theUserVerifiesIfMessageDisplay(String message) {
        BrowserUtilities.waitFor(3);
        BrowserUtilities.waitForVisibility(ss.toastMessageDeleted, 4);
        Assert.assertTrue(ss.toastMessageDeleted.getText().equals(message));
        System.out.println("s13");
        BrowserUtilities.waitForClickablility(ss.popUpCloseButton, 3);
        ss.popUpCloseButton.click();
        BrowserUtilities.clickWithJS(ss.logoutButton);
        Driver.closeDriver();
        BrowserUtilities.waitFor(1);

    }

    @When("the user clicks on Off Day button")
    public void theUserClicksOnOffDayButton() {
        BrowserUtilities.waitFor(3);
        BrowserUtilities.waitForClickablility(ss.addBlockTimeButton, 15);
        BrowserUtilities.clickWithJS(ss.offDayCheckbox);
    }

    @Then("the user verifies if the color of time section changes")
    public void theUserVerifiesIfTheColorOfTimeSectionChanges() {
        Assert.assertFalse(ss.addBlockTimeButton.isEnabled());
    }

    @Then("the user verifies if Off Day option is selected")
    public void theUserVerifiesIfOffDayOptionIsSelected() {
        Assert.assertTrue(ss.offDayCheckbox.isSelected());
    }

    @When("the user clicks on Customize your url")
    public void theUserClicksOnCustomizeYourUrl() {
        BrowserUtilities.clickWithJS(ss.customizeYourUrl);
    }

    @Then("the user verifies Upgrade Now popup is visible")
    public void theUserVerifiesUpgradeNowPopupIsVisible() {
        BrowserUtilities.waitForVisibility(ss.upgradeNowPopup, 4);
        Assert.assertTrue(ss.upgradeNowPopup.isDisplayed());
    }

    @Then("the user verifies {string} button is clickable on popup")
    public void theUserVerifiesButtonIsClickableOnPopup(String text) {
        WebElement element = driver.findElement(By.xpath("//span[text()='" + text + "']/.."));
        Assert.assertTrue(element.isEnabled());
    }

    @And("the user clicks on {string} button on popup")
    public void theUserClicksOnButtonOnPopup(String text) {
        WebElement element = driver.findElement(By.xpath("//span[text()='" + text + "']/.."));
        BrowserUtilities.clickWithJS(element);
    }



    @Then("the user verifies Upgrade Now popup ıs unvisible")
    public void theUserVerifiesUpgradeNowPopupIsUnvisible() {
        BrowserUtilities.waitFor(2);
        Assert.assertFalse(ss.upgradeNowPopup.isDisplayed());

    }
    @Then("the user verifies if Subscription page appears")
    public void theUserVerifiesIfSubscriptionPageAppears() {
        String currentURL = driver.getCurrentUrl();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parent = it.next();
        String child = it.next();
        driver.switchTo().window(child);
        String childWindowTitle = driver.getCurrentUrl();
        driver.close();
        driver.switchTo().window(parent);
        Assert.assertFalse(currentURL.equals(childWindowTitle));
        driver.close();


    }
}
