package com.demo.APIAutomation;

import com.demo.APIAutomation.DemoJira.Demo;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefinition
{
    Demo demo=new Demo(); //object

    @Given("^User navigates to the \"([^\"]*)\" website$")
    public void navigateToTheWebsite(String url)  {

        demo.navigateToTheWebsite(url);
    }



    @And("^I enter the username \"([^\"]*)\" and password \"([^\"]*)\" and I verify statuscode as \"([^\"]*)\"$")
    public void enterTheUsernameAndPasswordAndVerifyStatuscode(String username, String password, String statusCode){
        demo.enterTheUsernameAndPasswordAndVerifyStatuscode(username,password,statusCode);
    }

    @Then("^I verify name as \"([^\"]*)\" in the response$")
    public void verifyNameAsInTheResponse(String sessionName)  {
        demo.verifyNameAsInTheResponse(sessionName);

    }

    @Then("^I create an issue as \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void createAnIssue(String issueType, String description, String summary) {

        demo.createAnIssue(issueType,description,summary);
    }

    @Then("^I verify issue is created successfully$")
    public void verifyIssueIsCreatedSuccessfully() {
        demo.verifyIssueIsCreated();
    }


}
