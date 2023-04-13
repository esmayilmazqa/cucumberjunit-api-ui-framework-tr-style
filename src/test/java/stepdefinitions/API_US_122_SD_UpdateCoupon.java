package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.ApiUtilities;

import java.util.Map;

public class API_US_122_SD_UpdateCoupon {
    @Then("user verifies some values of the api response are true, only one json")
    public void userVerifiesSomeValuesOfTheApiResponseAreTrueOnlyOneJson(DataTable dTable) {
        Map<String, String> mTable = dTable.asMaps().get(0);
        //System.out.println(mTable);
        // keySet() içerisinden key leri alabilirsin. values() lar içinden de value ları
        for (String key : mTable.keySet()) {
            Assert.assertEquals(ApiUtilities.response.jsonPath().get(key).toString(),mTable.get(key));
        }
    }
}
