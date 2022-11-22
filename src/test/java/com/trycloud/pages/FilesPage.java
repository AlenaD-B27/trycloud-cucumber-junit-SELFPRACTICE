package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.trycloud.utilities.JavaUtils.*;

public class FilesPage extends BasePage {


    @FindBy(xpath = "//table[@id='filestable']//tr[@data-type='file']")
    public List<WebElement> tableRows;

    @FindBy(xpath = "//table[@id='filestable']//tr[@data-type='file']//a[contains(@href,'.php')]")
    public List<WebElement> listOfFiles;

    @FindBy(xpath = "//table[@id='filestable']//tr[@data-type='dir']//a[contains(@href,'php')]")
    public List<WebElement> listOfFolders;

    @FindBy(css = "div#recommendations")
    public WebElement recommendedFiles;

    @FindBy(css = "label[for='select_all_files']")
    public WebElement checkBoxForAll;

    @FindBy(xpath = "//input[contains(@id, 'select-files')]")
    public List<WebElement> checkBoxes;

    @FindBy(xpath = "(//span[@class='info'])[2]")
    public WebElement sortByNameBtn;

    @FindBy(css = "a.button.new")
    public WebElement addIcon;

    @FindBy(xpath = "//input[@type ='file']")
    public WebElement hiddenUploadBar;

    @FindBy(id = "uploadprogressbar")
    public WebElement uploadFileBar;

    @FindBy(xpath = "//form[@class='filenameform']//input[@type='text']")
    public WebElement folderNameInputBar;

    @FindBy(xpath = "//form[@class='filenameform']//input[@type='submit']")
    public WebElement submitNewFolderBtn;










    public void clickSubModule(String submodule){
        Driver.getDriver().findElement(By.xpath("//ul[@class='with-icon']//li//a[.='" + normalizeCase(submodule) + "']")).click();
    }

    // files and folders table:

    public String clickActionGetFileURLnostarFile(){

        String fileURL = "";
        WebElement actionLocator = null;

        for (int i = 0; i <= tableRows.size()-1; i++) {


            if(!Driver.getDriver().findElement(By.xpath("(//table[@id='filestable']//tr[@data-type='file']//div[contains(@class,'favorite-mark')])[" + (i+1) + "]")).getAttribute("class").contains("permanent")){ // favourited

                fileURL = Driver.getDriver().findElement(By.xpath("(//table[@id='filestable']//tr[@data-type='file']//a[contains(@href,'.php')])[" + (i+1) + "]")).getAttribute("href");

                actionLocator = Driver.getDriver().findElement(By.xpath("(//table[@id='filestable']//tr[@data-type='file']//span[@class='fileactions']//a[@data-action='menu'])[" + (i+1) + "]"));

                break;

            }
        }

        if(fileURL.isBlank()) {
            System.out.println("No files downloaded to the page or all the files are already added to favourites.");
        } else {
            System.out.println("LINK: " + fileURL);
            actionLocator.click();
        }
        return fileURL;
    }

    public String clickActionGetFileURLstarredFile(){

        String fileURL = "";
        WebElement actionLocator = null;

        for (int i = 0; i <= tableRows.size()-1; i++) {


            if(Driver.getDriver().findElement(By.xpath("(//table[@id='filestable']//tr[@data-type='file']//div[contains(@class,'favorite-mark')])[" + (i+1) + "]")).getAttribute("class").contains("permanent")){ // favourited

                fileURL = Driver.getDriver().findElement(By.xpath("(//table[@id='filestable']//tr[@data-type='file']//a[contains(@href,'.php')])[" + (i+1) + "]")).getAttribute("href");

                actionLocator = Driver.getDriver().findElement(By.xpath("(//table[@id='filestable']//tr[@data-type='file']//span[@class='fileactions']//a[@data-action='menu'])[" + (i+1) + "]"));

                break;

            }
        }

        if(fileURL.isBlank()) {
            System.out.println("No files downloaded to the page or none of the files are already added to favourites.");
        } else {
            System.out.println("LINK: " + fileURL);
            actionLocator.click();
        }
        return fileURL;
    }

    public void verifyFileIsDisplayed(String fileName){
        for (int i = 0; i < listOfFiles.size(); i++) {
            if(listOfFiles.get(i).getAttribute("href").contains(fileName)){
                Assert.assertTrue(listOfFiles.get(i).isDisplayed());
            }
        }
    }

    public void verifyFolderIsDisplayed(String folderName){
        for (int i = 0; i < listOfFolders.size(); i++) {
            if(listOfFolders.get(i).getAttribute("href").contains(folderName)){
                Assert.assertTrue(listOfFolders.get(i).isDisplayed());
            }
        }
    }



    //actionOptions dropdown menu when you click on "actions" icon (...)

    public void chooseActionOption(String option){
        Driver.getDriver().findElement(By.xpath("//ul//li[@class=' action-favorite-container']//span[.='" + option + "']")).click();
    }

    //add menu options

    public WebElement chooseAddOption(String option){
       return Driver.getDriver().findElement(By.xpath("//div[@class='newFileMenu popovermenu bubble menu open menu-left']//li//span[.='" + normalizeCase(option) + "']"));
    }



}
