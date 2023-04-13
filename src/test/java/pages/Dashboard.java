package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends Base{
    @FindBy(css = "[href='/dashboard/documents']")
    public WebElement documentsMenu;
}
