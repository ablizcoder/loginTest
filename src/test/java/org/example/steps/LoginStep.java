package org.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageobejectmodule.LoginPage;
import org.example.utility.TestBase;

public class LoginStep {

    LoginPage loginPage = new LoginPage();
    @Given("Tester should be able to write username")
    public void testerShouldBeAbleToWriteUsername() {
        loginPage.setUsername();
    }

    @When("Tester should be able to write password")
    public void testerShouldBeAbleToWritePassword() {
        loginPage.setPassword();
    }

    @Then("Tester should be able to click submit button")
    public void testerShouldBeAbleToClickSubmitButton() {
        loginPage.clickSubmitButton();
    }
}
