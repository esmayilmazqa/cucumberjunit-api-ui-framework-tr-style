package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonLoginTestSD {
    @Given("User hits the Amazon URL")
    public void userHitsTheAmazonURL() {
        System.out.println("Kullanici Amazon sayfasini acar");
    }

    @And("User clicks on the Login button")
    public void userClicksOnTheLoginButton() {
        System.out.println("Kullanici Login butonuna tiklar");
    }

    @And("User types its username in username textbox")
    public void userTypesItsUsernameInUsernameTextbox() {
        System.out.println("Kullanici username i yazar");
    }

    @And("User types its password in password textbox")
    public void userTypesItsPasswordInPasswordTextbox() {
        System.out.println("Kullanici password u yazar");
    }

    @When("User clicks on Submit buttonn")
    public void userClicksOnSubmitButtonn() {
        System.out.println("Kullanici Submit butonuna tiklar");
    }

    @Then("User verifies if success message appears")
    public void userVerifiesIfSuccessMessageAppears() {
        System.out.println("Kullanici successful yazisini gorur");
    }
}
