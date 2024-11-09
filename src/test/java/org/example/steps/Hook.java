package org.example.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.utility.TestBase;

public class Hook extends TestBase {
    @Before
    public void setUp(){
        initialization("url");
    }

    @After
    public void turnDown(){
        closeBrowser();
    }
}
