package stepdefinationFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFile.fanCodeCityPage;

public class fanCodeCitySteps {

    fanCodeCityPage page=new fanCodeCityPage();

    @Given("User has the todo tasks")
    public void user_has_the_todo_tasks() {
        page.userHasToDoTask();
    }
    @When("User belongs to the city FanCode")
    public void user_belongs_to_the_city_fan_code() {
        page.userBelongsToCityFanCode();
    }
    @Then("User Completed task percentage should be greater than <{int}> percent")
    public void user_completed_task_percentage_should_be_greater_than_percent(Integer int1) {
        page.userCompletedTaskShouldBeGreaterThanRequiredPercent(int1);
    }
}
