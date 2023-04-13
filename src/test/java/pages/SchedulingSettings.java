package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SchedulingSettings extends Base {
    // to control if admin page loads
    @FindBy(xpath = "//*[@aria-label='dashboard']")
    public WebElement dashboardMenu;

    @FindBy(xpath = "//*[@onClick='acceptCookie()']")
    public WebElement acceptCookieButton;

    @FindBy(css = ".hide-button")
    public WebElement belowSpeedToolbar;

    @FindBy(css = "button.ant-switch")
    public WebElement flexibleTimeButton;

    @FindBy(css = "td.ant-descriptions-item-content button")
    public WebElement customizeYourUrl;

    @FindBy(xpath = "(//span[text()='Off Day'])[2]/../span/input")
    public WebElement offDayCheckbox;

    @FindBy(xpath = "(//span[text()='Add Block Time'])[2]/..")
    public WebElement addBlockTimeButton;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(css = "div.ant-modal-content")
    public WebElement addBlockTimeContainer;

    @FindBy(css = "p.thisDayTitle")
    public WebElement dayTitle;

    @FindBy(css = "[name='eachDay']")
    public WebElement addButtonOnBlockTime;

    @FindBy(xpath ="(//input[contains(@id,'rc_select')])[1]")
    public WebElement addCbbStartTime; // Add combobox  start Block Time

    @FindBy(xpath ="(//input[contains(@id,'rc_select')])[2]")
    public WebElement addCbbEndTime; // Add Block Time

    @FindBy(xpath = "(//div[@class='rc-virtual-list-holder-inner'])[1]/div")
    public List<WebElement> addCbbStartTimes;

    @FindBy(xpath = "(//div[@class='rc-virtual-list-holder-inner'])[2]/div")
    public List<WebElement> addCbbEndTimes;

    @FindBy(xpath = "//h4[text()=' Blocked Times']")
    public WebElement blockTimesHeader;

    @FindBy(css = "div.ant-picker-disabled")
    public List<WebElement> blockTimesCbbs;

    @FindBy(css = "button[name='update']")
    public List<WebElement> updateButtons;


    @FindBy(css = "button[name='delete']")
    public List<WebElement> deleteButtons;

    @FindBy(xpath = "(//div[@role='document'])[2]/div[@class='ant-modal-content']")
    public WebElement updatePopup;

    @FindBy(css = "div.toast-message")
    public WebElement toastMessageGeneral;

    @FindBy(xpath = "//div[@class='toast-message' and text()='Block Time is deleted']")
    public WebElement toastMessageDeleted;

    @FindBy(xpath = "//button[@aria-label='Close']")
    public WebElement popUpCloseButton;


    @FindBy(xpath = "//div[@class='ant-modal-content']")
    public WebElement upgradeNowPopup;

    @FindBy(xpath = "//*[@aria-label='logout']/..")
    public WebElement logoutButton;


}
