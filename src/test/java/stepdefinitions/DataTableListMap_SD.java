package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class DataTableListMap_SD {
    @Then("user controls one column datatable for List")
    public void userControlsOneColumnDatatableForList(DataTable dtable) {
        List<String> dList = dtable.asList();

        System.out.println(dList);
        // [id, code, startsAt, endsAt, numberOfUsers, categories, discount, discountType]

        Map<String, String> mTable = dtable.asMap();
        System.out.println(mTable);
        // {id=null, code=null, startsAt=null, endsAt=null, numberOfUsers=null, categories=null, discount=null, discountType=null}

    }

    @Then("user controls two column datatable for List")
    public void userControlsTwoColumnDatatableForList(DataTable dtable) {
        //List<String> table = dtable.asList();
        //io.cucumber.datatable.UndefinedDataTableTypeException: Can't convert DataTable to List<java.lang.String>.

        List<List<String>> table = dtable.asLists();
        System.out.println(table);
        // [[id, numberOfUsers], [code, categories], [startsAt, discount], [endsAt, discountType]]

    }

    @Then("user controls four column datatable for List")
    public void userControlsFourColumnDatatableForList(DataTable dtable) {
        List<List<String>> table = dtable.asLists();
        System.out.println(table);
        // [[id, numberOfUsers, startsAt, discount], [code, categories, endsAt, discountType]]
    }

    @Then("user controls two column datatable for Map")
    public void userControlsTwoColumnDatatableForMap(DataTable dtable) {
        Map<String, String> mTable = dtable.asMap();
        System.out.println(mTable);
        //{id=numberOfUsers, code=categories, startsAt=discount, endsAt=discountType}
    }

    @Then("user controls two column and two row datatable for Map")
    public void userControlsTwoColumnAndTwoRowDatatableForMap(DataTable dtable) {
        Map<String, String> mTable = dtable.asMap();
        System.out.println(mTable);
        // {id=numberOfUsers, code=categories}
    }

    @Then("user controls four column and two row datatable for Map")
    public void userControlsFourColumnAndTwoRowDatatableForMap(DataTable dtable) {
        //io.cucumber.datatable.CucumberDataTableException: Can't convert DataTable to Map<java.lang.String, java.lang.String>.
        // Map<String,String> mTable = dtable.asMap();


        List<Map<String, String>> mTable = dtable.asMaps();
        System.out.println(mTable);
        // [{id=code, numberOfUsers=categories, startsAt=endsAt, discount=discountType}]
    }


    @Then("user controls five column and four row datatable for Map")
    public void userControlsFiveColumnAndFourRowDatatableForMap(DataTable dTable) {
        List<Map<String, String>> table = dTable.asMaps();
        System.out.println(table);
        // [{id=code, numberOfUsers=categories, startsAt=endsAt, discount=discountType},
        // {id=aaaaa, numberOfUsers=bbbbb, startsAt=cccccc, discount=ddddddddddddd},
        // {id=eeeeeeeeeeee, numberOfUsers=fffffff, startsAt=ggggg, discount=hhhhhhh}]
    }
}
