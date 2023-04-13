package pages;

import org.openqa.selenium.WebElement;
import utilities.BrowserUtilities;
import utilities.Driver;

public class Dummy {
    public static void main(String[] args) {
        HomePage page = new HomePage();
        Driver.getDriver().get("https://qa-test.hypnotes.net/");
        BrowserUtilities.scrollToElement(page.customizeYourService);
        //WebElement element = BrowserUtilities.getElementFromGetText( "Video Conferencing - Telehealth");
        WebElement element = BrowserUtilities.getElementFromGetText("Video Conferencing - Telehealth");
        System.out.println(element.getText());
    }
}
