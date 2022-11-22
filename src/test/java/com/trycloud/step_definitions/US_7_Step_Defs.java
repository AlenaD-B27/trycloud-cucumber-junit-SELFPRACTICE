package com.trycloud.step_definitions;

import com.github.javafaker.Faker;
import com.trycloud.pages.FilesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;


public class US_7_Step_Defs {

    FilesPage filesPage = new FilesPage();

    Faker faker = new Faker();

    String newFolderName = faker.book().title();

    @When("user click {string}")
    public void user_click(String option) {
        filesPage.chooseAddOption(option).click();
        //"new folder" option
    }

    @When("user write a folder name")
    public void user_write_a_folder_name() {
        filesPage.folderNameInputBar.sendKeys(newFolderName);
    }

    @When("the user click submit icon")
    public void the_user_click_submit_icon() {
        filesPage.submitNewFolderBtn.click();
        System.out.println("\"" + newFolderName + "\"" + " folder is added.");
    }

    @Then("Verify the folder is displayed on the page")
    public void verify_the_folder_is_displayed_on_the_page() {
        filesPage.verifyFolderIsDisplayed(newFolderName);
    }

    @When("user choose a folder from the page")
    public void user_choose_a_folder_from_the_page() {
        WebElement firstFolderOnThePage = filesPage.listOfFolders.get(0);
        System.out.println("Opening folder: \"" + firstFolderOnThePage.getText() + "\" ...");
        firstFolderOnThePage.click();
    }









}
