package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import org.junit.Assert;
import utilities.ApiUtilities;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class API_US120_SD_AddCreateNewCoupon {
    @Given("user connects to the {string} api with body, POST")
    public void userConnectsToTheApiPOST(String endPoint, DataTable dataTable) {

        Map<String, String> mandatoryFields = dataTable.asMaps().get(0);
        System.out.println(mandatoryFields);
        // {rate=5, feedback=good, userEmail=exe@gmail.com, fullname=Ali Veli



        ApiUtilities.response = given().
                contentType(ContentType.URLENC.withCharset("UTF-8")). // UTF-8 yardımıyla türkçe karakter tanımı ekledik
                contentType(ContentType.MULTIPART).
                spec(ApiUtilities.specification).
                formParams(mandatoryFields).
                post(endPoint);

        // 2. Yöntem
/*      JSONObject object = new JSONObject();
        {
            username : "hamza",
            password : "1234"
        }
        object.put("promoCode","DENEME");
        object.put("startedAt","Thu, 23 Jun 2022 11:28:59 GMT");

        ApiUtilities.response = given().
                contentType(ContentType.JSON).
                spec(ApiUtilities.specification).
                body(object.toString()).
                post(endPoint);
*/

       ApiUtilities.response.prettyPrint();
    }


    @Then("user verifies the api response has mandatory fields, only one json")
    public void userVerifiesTheApiResponseHasMandatoryFieldsOnlyOneJson(DataTable dataTable) {
        List<String> zorunluAlanlar = dataTable.asList(); // success

        for (String field : zorunluAlanlar) {
            Assert.assertTrue(ApiUtilities.response.jsonPath().get(field) != null);
        }
    }
}
