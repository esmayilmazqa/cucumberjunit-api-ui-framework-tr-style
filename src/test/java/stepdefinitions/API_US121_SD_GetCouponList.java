package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import org.junit.Assert;
import utilities.ApiUtilities;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class API_US121_SD_GetCouponList  {

    @Given("user connects to the {string} api without body") // post method
    public void userConnectsToTheApi(String endPoint) {
        //given ile baglantı gidiyor, eklemek istediklerini ekle:
        ApiUtilities.response = given().
                contentType(ContentType.JSON).
                spec(ApiUtilities.specification).
                post(endPoint);
        // request in response da hemen aliniyor

        // response console düzgün bir şekilde bas :
        ApiUtilities.response.prettyPrint();

        //contentType bölümünde bağlantının hangi tipte olacağını söyleyebilirsin.
        // Ben baglaniyorum ama almak istediğim cevap kabul edeceğim cevap şudur diyoruz.
        // Bu bilgiyi swagger dokumanında response kısmından
        // alıyorsun. --application/json

        // yani aslnda given() ile gonderecegimiz request e gerekli ayarlari girdigimiz gibi
        // API a vermek istediğimiz mesajları da veriyoruz. Bize response u bu tipte ver gb
    }

    @Then("user verifies the status code of the response is {string}")
    public void userVerifiesTheStatusCodeOfTheResponseIs(String statusCode) {
        int currentStatusCode = ApiUtilities.response.statusCode();

        Assert.assertEquals(Integer.parseInt(statusCode), currentStatusCode);

    }


    @Then("user verifies the api response has mandatory fields in array")
    public void userVerifiesTheApiResponseHasMandatoryFieldsInArray(DataTable dataTable) {
        List<String> mandatoryFields = dataTable.asList(); // id, code, startsAt...
        // [id, code, startsAt, endsAt, numberOfUsers, categories, discount, discountType]

        // SORU -> LinkedHashMap donecegini nereden biliyorduk
        List<LinkedHashMap> maps = ApiUtilities.response.jsonPath().get("$");
        // list -> [] array ama içinde {id=256,..} datalar var, her bir json => map e donusmus

        for (LinkedHashMap map : maps) {
            for (String field : mandatoryFields) {
                Assert.assertTrue(map.get(field) != null);
                //Assert.assertNotNull(map.get(field));
            }
        }
   /* {id=59, code=NewJersey, startsAt={date=2022-06-23 20:22:00.000000, timezone_type=3,
        timezone=UTC}, endsAt={date=2022-06-24 20:22:00.000000, timezone_type=3, timezone=UTC},
        numberOfUsers=50, categories=[2], discount=25, discountType=20}
        */
    }


}

