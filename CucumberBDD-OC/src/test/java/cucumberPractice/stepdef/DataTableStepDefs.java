package cucumberPractice.stepdef;

import cucumberPractice.objects.Customer;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

public class DataTableStepDefs {

    //Use the List<String> if the step arguments does not contain header
    /*@DataTableType
    public Customer customerEntry(List<String> entry) {
        //return new Customer(entry.get(0), entry.get(0));    //use this in case of single row with many columns
        return new Customer(entry.get(0), entry.get(1));    //use this in case of single column with many rows
    }*/

    //Use the Map<String, String> if the step arguments contain header
    @DataTableType
    public Customer customerEntryMap(Map<String, String> entry) {
        return new Customer(entry.get("username"), entry.get("password"));
    }

    @Given("my credentials")
    public void myCredentials(Customer customer) {
        //Use these if you are passing Datatable datatable as step argument
        //List<String> creds = dataTable.asList();    //use asList() if dataTable parameters are vertical single column
        //List<String> creds = dataTable.values();    //use values() if dataTable parameters are horizontal
        //List<String> creds = dataTable.row(0);    //use rows() if you want to fetch the first row or rows(startRow, endRow) for multiple rows
        //System.out.println("USERNAME = " + creds.get(0));
        //System.out.println("PASSWORD = " + creds.get(1));

        //use this if you are passing List<List<String>> creds as step argument
        //BAD Practice, use custom domain object instead
        //Customer customer = new Customer(creds.get(0).get(0), creds.get(0).get(1));
        //System.out.println("USERNAME = " + creds.get(0).get(0));
        //System.out.println("PASSWORD = " + creds.get(0).get(1));

        //Use this if you are passing customer domain object as step argument
        //GOOD practice, use domain objects with cucumber dataTable transformer
        System.out.println("USERNAME = " + customer.getUsername());
        System.out.println("PASSWORD = " + customer.getPassword());


    }

    @Given("many credentials")
    public void manyCredentials(List<Customer> customers) {
        //List<List<String>> creds = dataTable.asLists(); //returns list of list

        //BAD PRACTICE
        //Use this snipped if you are passing List<List<String>> creds as parameter
        /*System.out.println("ROW 0 USERNAME = " + creds.get(0).get(0));
        System.out.println("ROW 0 PASSWORD = " + creds.get(0).get(1));
        System.out.println("ROW 1 USERNAME = " + creds.get(1).get(0));
        System.out.println("ROW 1 PASSWORD = " + creds.get(1).get(1));*/

        //GOOD PRACTICE
        //Note that in real projects, we will create a separate custom domain object with methods to retrieve specific customer information
        ///Use this snipped if you are passing List<Customer> customers as parameter
        System.out.println("ROW 0 USERNAME = " + customers.get(0).getUsername());
        System.out.println("ROW 0 PASSWORD = " + customers.get(0).getPassword());
        System.out.println("ROW 1 USERNAME = " + customers.get(1).getUsername());
        System.out.println("ROW 1 PASSWORD = " + customers.get(1).getPassword());
    }


    /**
     * SINGLE ROW WITH HEADER
     * | username | password |
     * | john     | john123  |
     *
     * @param creds
     */
    @Given("credentials for single row with header")
    public void credentialsForSingleRowWithHeader(List<Map<String, String>> creds) {
        /*
        List<List<String>>
         [
           ["username", "password"],
           ["john", "123"]
         ]
        */
        //use this if you are passing List<List<String>> creds as step argument
        /*System.out.println("USERNAME = " + creds.get(1).get(0));
        System.out.println("PASSWORD = " + creds.get(1).get(1));*/

        /*
          List<Map<String, String>>
          [
            {
               "username": "john",
               "password": "john123"
             }
          ]
        */
        //use this if you are passing List<Map<String, String>> creds as step argument
        System.out.println("USERNAME = " + creds.get(0).get("username"));
        System.out.println("PASSWORD = " + creds.get(0).get("password"));
    }

    /**
     * SINGLE ROW WITH HEADER
     * | username | password |
     * | john     | john123  |
     * | bill     | bill123  |
     *
     * @param creds
     */
    @Given("credentials for multiple rows with header")
    public void credentialsForMultipleRowsWithHeader(List<Map<String, String>> creds) {
        System.out.println("ROW 0 USERNAME = " + creds.get(0).get("username"));
        System.out.println("ROW 0 PASSWORD = " + creds.get(0).get("password"));
        System.out.println("ROW 1 USERNAME = " + creds.get(1).get("username"));
        System.out.println("ROW 1 PASSWORD = " + creds.get(1).get("password"));
    }

    @Given("credentials for row with header data table type")
    public void credentialsForRowWithHeaderDataTableType(Customer customer) {
        System.out.println("USERNAME = " + customer.getUsername());
        System.out.println("PASSWORD = " + customer.getPassword());
    }

    @Given("credentials for multiple rows with header data table type")
    public void credentialsForMultipleRowsWithHeaderDataTableType(List<Customer> customers) {
        //In real project, we can set the corresponding java object in transformer function and use the values here
        System.out.println("ROW 0 USERNAME = " + customers.get(0).getUsername());
        System.out.println("ROW 0 PASSWORD = " + customers.get(0).getPassword());
        System.out.println("ROW 1 USERNAME = " + customers.get(1).getUsername());
        System.out.println("ROW 1 PASSWORD = " + customers.get(1).getPassword());
    }

    @Given("credentials for single column with no header")
    public void credentialsForSingleColumnWithNoHeader(DataTable datatable) {
        //You can either use List<String> cred or Datatable datatable as parameter
        List<String> cred = datatable.asList();
        System.out.println("USERNAME = " + cred.get(0));
        System.out.println("PASSWORD = " + cred.get(1));
    }

    @Given("credentials for single column with header")
    public void credentialsForSingleColumnWithHeader(DataTable dataTable) {
        //You can either use Map<String, String> cred or Datatable datatable as parameter
        Map<String, String> cred = dataTable.asMap();
        System.out.println("USERNAME = " + cred.get("username"));
        System.out.println("PASSWORD = " + cred.get("password"));
    }

    @Given("credentials for single column with no header data table type")
    public void credentialsForSingleColumnWithNoHeaderDataTableType(@Transpose Customer customer) {
        System.out.println("USERNAME = " + customer.getUsername());
        System.out.println("PASSWORD = " + customer.getPassword());
    }

    @Given("credentials for single column with header data table type")
    public void credentialsForSingleColumnWithHeaderDataTableType(@Transpose Customer customer) {
        System.out.println("USERNAME = " + customer.getUsername());
        System.out.println("PASSWORD = " + customer.getPassword());
    }

    /*@Given("my credentials for multiple columns with header data table type")
    public void myCredentialsForMultipleColumnsWithHeaderDataTableType(@Transpose List<Customer> customers) {
        System.out.println("COLUMN 0 USERNAME = " + customers.get(0).getUsername());
        System.out.println("COLUMN 0 PASSWORD = " + customers.get(0).getPassword());
        System.out.println("COLUMN 1 USERNAME = " + customers.get(1).getUsername());
        System.out.println("COLUMN 1 PASSWORD = " + customers.get(1).getPassword());
    }*/

    //Alternatively you can achieve the same output using DataTable as step argument instead of using custom data type as in above step definition.
    @Given("my credentials for multiple columns with header data table type")
    public void myCredentialsForMultipleColumnsWithHeaderDataTableType(DataTable dataTable) {
        List<Map<String, String>> cred = dataTable.transpose().asMaps();
        System.out.println("COLUMN 0 USERNAME = " + cred.get(0).get("username"));
        System.out.println("COLUMN 0 PASSWORD = " + cred.get(0).get("password"));
        System.out.println("COLUMN 1 USERNAME = " + cred.get(1).get("username"));
        System.out.println("COLUMN 1 PASSWORD = " + cred.get(1).get("password"));
    }


}
