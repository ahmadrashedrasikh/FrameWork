package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.DashboardPage;
import utils.CommonMethods;

import java.util.ArrayList;
import java.util.List;

public class DashboardSteps extends CommonMethods {

    @Then("user print the dashboard tab list as below")
    public void user_print_the_dashboard_tab_list_as_below(DataTable dataTable) {

        List<List<String>>tableList=dataTable.asLists();

        List<String> expectedTabs=new ArrayList<>();


        DashboardPage das=new DashboardPage();
        List<String> actualList=new ArrayList<>();

        for (WebElement ele:das.dashboardTabs) {
            actualList.add(ele.getText());
            for (List<String> tabs:tableList) {
                expectedTabs=tabs;
            }
        }

        System.out.println(actualList);
        System.out.println(expectedTabs);

        Assert.assertEquals(actualList, expectedTabs);

    }
}
