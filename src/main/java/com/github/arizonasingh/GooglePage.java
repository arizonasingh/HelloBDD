package com.github.arizonasingh;

import com.github.arizonasingh.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends Base {

    private WebDriver driver;

    @FindBy(name = "q")
    WebElement searchBox;

    @FindBy(name = "btnK")
    WebElement searchBtn;

    public void openApp(WebDriver driver){
        driver.get(getAppURL());
    }

    public void enterGoogleSearch(String search){
        searchBox.sendKeys(search);
    }

    public void clickGoogleSearch(){
        searchBtn.click();
    }

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
