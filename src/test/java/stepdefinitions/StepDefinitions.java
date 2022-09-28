package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.PrettifyYourNumber;
import utils.Driver;

public class StepDefinitions {
    PrettifyYourNumber prettify = new PrettifyYourNumber();
    @Given("user is on the website home page")
    public void user_is_on_the_website_home_page() {
        Driver.getDriver().get("prettifyyournumber.com");
    }
    @When("user enters a number")
    public void user_enters_a_number() {
        prettify.inputBox.sendKeys("2458707");
        prettify.submitButton.click();
    }
    @Then("The number should be prettified")
    public void the_number_should_be_prettified() {
        String expected = "2.4M";
        String actual = prettify.output.getText();
        Assert.assertEquals(expected, actual);
    }
    @Then("Close the application")
    public void close_the_application() {
        Driver.closeDriver();
    }
    @When("user enters a char other then a number")
    public void user_enters_a_char_other_then_a_number() {
        prettify.inputBox.sendKeys("notanumber");
        prettify.submitButton.click();
    }
    @Then("warning should be appeared")
    public void warning_should_be_appeared() {
        String expected = "Invalid input! Only numbers accepted.";
        String actual = prettify.warning.getText();
        Assert.assertEquals(expected, actual);
    }
}
