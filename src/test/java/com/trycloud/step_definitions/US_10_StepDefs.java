package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import static com.trycloud.utilities.BrowserUtils.*;


public class US_10_StepDefs {

    FilesPage filesPage = new FilesPage();

    @When("user clicks Settings on the left bottom corner")
    public void user_clicks_settings_on_the_left_bottom_corner() {
        filesPage.settingsBtn.click();
        for(WebElement eachOptionCheckbox : filesPage.settingsClickableOptionsCheckboxes){
            waitForClickability(eachOptionCheckbox, 10);
        }
    }

    @Then("the user should be able to click any buttons")
    public void the_user_should_be_able_to_click_any_buttons() {
        for(int i = 0; i < filesPage.settingsOptionsCheckboxes.size(); i++){
            waitForClickability(filesPage.settingsClickableOptionsCheckboxes.get(i), 10);
            if(filesPage.settingsOptionsCheckboxes.get(i).isSelected()){
                filesPage.settingsClickableOptionsCheckboxes.get(i).click();
                Assert.assertFalse(filesPage.settingsOptionsCheckboxes.get(i).isSelected());
            } else {
                filesPage.settingsClickableOptionsCheckboxes.get(i).click();
                Assert.assertTrue(filesPage.settingsOptionsCheckboxes.get(i).isSelected());
            }
        }
    }



}
