package com.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactsPage extends BasePage{


    @FindBy(className = "app-content-list-item-line-one")
    public List<WebElement> contactsNameList;


}
