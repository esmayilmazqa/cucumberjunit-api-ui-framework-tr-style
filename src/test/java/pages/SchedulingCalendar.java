package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SchedulingCalendar extends Base {
    @FindBy(xpath = "//*[text()='Block Time']/..")
    public WebElement blockTimeBtn;

    @FindBy(xpath = "//td[contains(@class,'fc-day-today')]")
    public WebElement todayDateCell;

    @FindBy(xpath = "//*[text()='Submit']/..")
    public WebElement submmitBtn;

    @FindBy(css = "div.ant-drawer-wrapper-body")
    public WebElement appointmentPopup;

    @FindBy(xpath = "//input[@value='registered']")
    public WebElement radioRegisService;

    @FindBy(xpath = "//input[@id='rc_select_0']/../../..")
    public WebElement serviceDropdown;

    @FindBy(xpath = "//input[@id='rc_select_1']/../../..")
    public WebElement locationDropdown;

    @FindBy(xpath = "//div[@class='rc-virtual-list-holder-inner']/div/div")
    public List<WebElement> comboboxElements;
    //rc-virtual-list-holder-inner

    // US_98 locators
    @FindBy(css = "div.fc-daygrid-event-harness")
    public WebElement anyAppoinCell;

    public By anyAppoinCellNameInfo = By.cssSelector("div.fc-sticky");
    //div[@class='fc-daygrid-event-harness']/../../..
    public By anyAppoinCellMain =  By.xpath("../../..");

    @FindBy(xpath = "(//div[@class='ant-col ant-col-12'])[3]/button[1]")
    public WebElement googleBtn;

    @FindBy(xpath = "(//div[@class='ant-col ant-col-12'])[3]/button[2]")
    public WebElement outlookBtn;

    @FindBy(xpath = "//div[@class='ant-drawer-title']/../..")
    public WebElement meetInfoForm;

    @FindBy(css = "div.ant-radio-group label input")
    public List<WebElement> radioBtnsInMeetInfo;

    @FindBy(xpath = "//div[@class='ant-drawer-body']/div[5]/div[3]/div")
    public WebElement dateMeetInfo;

    @FindBy(xpath = "(//*[@class='ant-row'])[5]/div/div/button")
    public List<WebElement> goToMeetingBtns;

}
