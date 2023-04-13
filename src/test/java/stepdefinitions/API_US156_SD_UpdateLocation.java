package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ApiUtilities;
import utilities.BrowserUtilities;
import utilities.Driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class API_US156_SD_UpdateLocation {
    @Given("user connects to the {string} api without body to get data")
    public void userConnectsToTheApiWithoutBodyToGetData(String endPoint, DataTable dataTable) {
        ApiUtilities.response = given().
                contentType(ContentType.JSON).
                spec(ApiUtilities.specification).
                post(endPoint);

        List<String> data = dataTable.asList();
        //System.out.println(ApiUtilities.response.jsonPath().get(data.get(0)).toString());
        //id geliyor bunu bir yere kaydetmek lazım.
        String locationId = ApiUtilities.response.jsonPath().get(data.get(0)).toString();
        BrowserUtilities.writeDataToIdsFile("locationId",locationId);
    }

    @Given("user connects to the {string} api with body,POST; changing {string} field")
    public void userConnectsToTheApiWithBodyPOSTChangingField(String endPoint, String changeableField, DataTable dataTable) {
        Map<String, String> requestBody = dataTable.asMaps().get(0);
        // {rate=5, feedback=good, userEmail=exe@gmail.com, fullname=Ali Veli

        //Map<String, String> nwMap = Map.copyOf(mTable); -> calismadi
        Map<String, String> nwMap = new HashMap<String, String>();
        nwMap.putAll(requestBody); // copy from requestBody to nwMap

        String newValue = BrowserUtilities.readDataFromIdsFile(requestBody.get(changeableField)); //locationId
        nwMap.replace(changeableField,newValue);

        System.out.println(nwMap);

        ApiUtilities.response = given().
                contentType(ContentType.URLENC.withCharset("UTF-8")). // UTF-8 yardımıyla türkçe karakter tanımı ekledik
                        contentType(ContentType.MULTIPART).
                spec(ApiUtilities.specification).
                formParams(nwMap).
                post(endPoint);
    }


}
