package com.demo.APIAutomation.DemoJira;


import com.demo.APIAutomation.Utils.BaseClass;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.*;



public class Demo extends BaseClass
{

    String response;
    SessionFilter session = new SessionFilter();  //session object stores the response  of the
                                                 //session we can use in the subsequent code
    String issueResponse;


    public void navigateToTheWebsite(String url)
    {
            setUp(url);
    }

    public void enterTheUsernameAndPasswordAndVerifyStatuscode(String username, String password, String statusCode)
    {

            int status_Code=Integer.parseInt(statusCode);
            System.out.println("Session Login is "+session);

            response=given().header("Content-Type","application/json")
                .body(" {\"username\": \""+username+"\", \"password\": \""+password+"\" }")
                .log().all()
                .filter(session)
                .when()
                .post("/rest/auth/1/session")

                .then().log().all()
                .assertThat().statusCode(status_Code)
                .extract().response().asString();
    }


    public void verifyNameAsInTheResponse(String sessionName)
    {
        System.out.println("\n \n Response is:"+response);


        JsonPath responseJSON=new JsonPath(response);

        String sessName=responseJSON.get("session.name");

        Assert.assertEquals(sessName,sessionName,"Session Not Created");

    }

    public void createAnIssue(String issueType,String description,String summary)
    {
        System.out.println("Session create issue is "+session);

        issueResponse = given().header("Content-Type","application/json")
                .body(" {\n" +
                        "    \"fields\":{\n" +
                        "        \"project\":\n" +
                        "        {\n" +
                        "            \"key\": \"CARSGUIDE\"\n" +
                        "        },\n" +
                        "        \"summary\":\""+summary+"\",\n" +
                        "        \"description\":\""+description+"\",\n" +
                        "        \"issuetype\":{\n" +
                        "         \"name\":\""+issueType+"\"\n" +
                        "        }\n" +
                        "\n" +
                        "\n" +
                        "    }\n" +
                        "}")
                .log().all()
                .filter(session)
                .when()
                    .post("/rest/api/2/issue")

                .then()
                    .log().all()
                    .extract().response().asString();

        System.out.println("Creating a issue:"+issueResponse);

    }


    public void verifyIssueIsCreated() {

        JsonPath responseJSON=new JsonPath(issueResponse);  //string to json

        String ID=responseJSON.get("id");



        if(ID!="")
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false,"Issue Not Created");
        }
    }
}
