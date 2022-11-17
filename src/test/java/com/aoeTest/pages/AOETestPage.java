package com.aoeTest.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class AOETestPage {
    WebDriver driver;

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    public WebElement cookieBtn;

    @FindBy(xpath = "//a[@data-qa='nav_main_6']")
    public WebElement careerBtn;

    @FindBy(xpath = "//a[@data-qa='nav_main_6_4']")
    public WebElement vacanciesBtn;

    @FindBy(xpath = "//input[@id='filter-keyword']")
    public WebElement keywordBtn;

    @FindBy(xpath = "//a[@data-qa='vacancies_table_16']")
    public WebElement vacancyFrontent;

    @FindBy(xpath = "//a[contains(@data-qa,'vacancies_table')][contains(text(),'Frontend')]/..")
    public List<WebElement> jobOffering;

    @FindBy(css = "a[data-qa='vacancies_table_16']")
    public WebElement jobOffering1;

    @FindBy(xpath = "//h1[contains(text(),'Frontend / React Developer (m/f/d), remote')]")
    public WebElement verifyOption;

    public WebElement offering(String vacancy) {
        WebElement offer=driver.findElement(By.xpath("//a[contains(@data-qa,'vacancies_table')][contains(text(),'" + vacancy + "')]"));
        return offer;
    }

    public List<String> offeringList(){
        List<String> actualList=new ArrayList<>();
        List<WebElement> element=jobOffering;
        for (WebElement actualElementlist : element) {
            actualList.add(actualElementlist.getText());
        }
        return actualList;
    }


//In Page Factory, testers use @FindBy annotation. The initElements method is used to initialize web elements.
//@FindBy: An annotation used in Page Factory to locate and declare web elements using different locators.
// Below is an example of declaring an element using @FindBy

    public AOETestPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
