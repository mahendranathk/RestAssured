package com.demo.APIAutomation.Utils;

import io.restassured.RestAssured;

public class BaseClass
{

    public void setUp(String url)
    {
        RestAssured.baseURI = url;
    }

}
