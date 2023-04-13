package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtilities;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DB_US163_SD_getCouponList {


    @Given("user connects to the database")
    public void userConnectsToTheDatabase() throws SQLException {
        //DBUtilities.getConnection().createStatement();
        DBUtilities.getConnection();
        DBUtilities.createStatement();
    }

    @Then("user verifies the {string} table has the columns")
    public void userVerifiesTheTableHasTheColumns(String table, DataTable dtable) throws SQLException {
        List<String> columns = dtable.asList(); //[code,column]
        //String columnsName = columns.toString().replace("[", "").replace("]", "");
        //String query = "select " + columnsName + " from " + table;

        String query = "select *  from " + table;
        DBUtilities.createResultSet(query);
        //column ile alakalı datalari getiriyor :

        ResultSetMetaData rsmd = DBUtilities.resultSet.getMetaData();
        //String columnName = rsmd.getColumnName(1);
        int columnCount = rsmd.getColumnCount();

        for (String column : columns) {
            boolean columnExist = false;
            for (int i = 1; i <= columnCount; i++) { // esitlik ve 1 dikkat
                if (rsmd.getColumnName(i).equals(column))
                    columnExist = true;
            }
            Assert.assertTrue(columnExist);
        }

    }

    @Then("user verifies the codes are unique for same user_id")
    public void userVerifiesTheCodesAreUniqueForSameUser_id() throws SQLException {
        HashMap<String, List<String>> map = new HashMap<>();

        while (DBUtilities.resultSet.next()) {
            String userId = DBUtilities.resultSet.getString("user_id");
            String code = DBUtilities.resultSet.getString("code");
            // 5 -> []
            if (map.get(userId) != null) {
                if (map.get(userId).contains(code)) { //5 -> List[] bu listede code var mı
                    System.out.println(userId + " zaten " + code + " isminde kupon oluşturmuş.");
                    Assert.assertTrue(false); // bu liste "code" u iceriyor mu

                } else {
                    map.get(userId).add(code);
                }
            } else { // liste olusuyor ve ilk eleman burada ekleniyor
                List<String> s = new ArrayList<>();
                s.add(code);
                map.put(userId, s);
            }

        }
        System.out.println(map);


    }
}

/*    Veritabanını görebilmek için
        File > Settings
        Plugins tabına geç	-> Database Navigator
        yaz.*/

// Bu eklenti ile üst menuye DB Navigator geliyor
// sol tarafa da DB Browser geliyor, + ya tıkla MySql seç
// veritabanını intellij de gormemizi sagliyor