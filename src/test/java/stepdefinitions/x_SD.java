package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BrowserUtilities;
import utilities.Driver;

import java.util.List;

public class x_SD {
    @Given("the user is on clients page")
    public void theUserIsOnClientsPage() {
        WebElement controlBtn = Driver.getDriver().findElement(By.xpath("//span[text()='Add Client']/.."));
        BrowserUtilities.waitForClickablility(controlBtn, 9);
    }

    @When("the user collects all of clients in the page")
    public void theUserCollectsAllOfClientsInThePage() {
     /*   BrowserUtilities.scrollUntilEnd(Driver.getDriver());
        WebElement container = Driver.getDriver().findElement(By.xpath("//ul[@class='ant-list-items']"));
        //ul[@class='ant-list-items']/div
        List<WebElement> clientCards = container.findElements(By.xpath("div[contains(@class,'ant-card-bordered')]"));

        WebElement wanted = null;
        System.out.println(clientCards.size());
        for (WebElement clientCard : clientCards) {
            WebElement client = clientCard.findElement(By.tagName("h5"));
            if(client.getText().equals("Ahmet Demir")) {
                wanted = client;
                break;
            }
        }
        String link = wanted.findElement(By.xpath("..")).getAttribute("href");
        System.out.println(link);*/

    }

    @Then("the user verifies that knows scope limiting concept")
    public void theUserVerifiesThatKnowsScopeLimitingConcept() {
        BrowserUtilities.scrollUntilEnd(Driver.getDriver());
        WebElement container = Driver.getDriver().findElement(By.xpath("//ul[@class='ant-list-items']"));

        List<WebElement> clientCards = container.findElements(By.cssSelector("div.ant-card-bordered"));

        WebElement client= null;
        for (WebElement card : clientCards) {
            client = card.findElement(By.tagName("h5"));
            if(client.getText().equals("Ahmet Demir"))
            {
                break;
            }

        }
        String wantedLink = client.findElement(By.xpath("..")).getAttribute("href");


        String id = wantedLink.split("client/")[1];
        System.out.println(id);



    }
}


