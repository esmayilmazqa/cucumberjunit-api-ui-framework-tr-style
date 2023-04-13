package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.AmazonPage;
import utilities.Driver;

public class AmazonAramaSD {
    AmazonPage ap = new AmazonPage();

    @Given("user lands on Amazon")
    public void user_lands_on_amazon() {
        System.out.println("given kismi");
        Driver.getDriver().get("http://www.amazon.com");
    }

    @When("user types iphone on search textbox")
    public void user_types_iphone_on_search_textbox() {
        System.out.println("when kismi");
        ap.getTxtSearch().sendKeys("iphone" + Keys.ENTER);
        //ap.getTxtSearch().sendKeys(Keys.ENTER);
    }

    @Then("user prints the  result of products number to console")
    public void user_prints_the_result_of_products_number_to_console() {
        System.out.println("then kismi");
        int number = Integer.parseInt(ap.getResultNumber().getText().split(" ")[2]);
        System.out.println(number);
    }
}
