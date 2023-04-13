package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import utilities.ApiUtilities;

import java.util.Map;
import java.util.*;


import static io.restassured.RestAssured.given;

public class API_US124_SD_AddNewIndividualSession {
    @Given("user connects to the {string} api with body missing fields {string}, POST")
    public void userConnectsToTheApiWithBodyMissingFieldsPOST(String endPoint, String missingField, DataTable dtable) {
        Map<String, String> mTable = dtable.asMaps().get(0); //unmodifiable collection,UnsupportedOperationException -> java.util.Collections$UnmodifiableMap

        //Map<String, String> nwMap = Map.copyOf(mTable); -> calismadi
        Map<String, String> nwMap = new HashMap<String, String>();
        nwMap.putAll(mTable);

        for (String key : nwMap.keySet()) {
            if (key.equals(missingField)) {
                nwMap.replace(key, "");
                break;
            }
        }
        //System.out.println(nwMap);
        ApiUtilities.response = given()
                .contentType(ContentType.URLENC.withCharset("UTF-8")) // UTF-8 yardımıyla türkçe karakter tanımı ekledik
                .contentType(ContentType.MULTIPART)
                .spec(ApiUtilities.specification)
                .formParams(nwMap)
                .post(endPoint);

        ApiUtilities.response.prettyPrint();
    }
}
