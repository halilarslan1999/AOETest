package com.aoeTest.tests.aoeTest;

import com.aoeTest.pages.AOETestPage;
import com.aoeTest.tests.TestBase.TestBase;
import com.aoeTest.utilities.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class aoeRecruitingTest extends TestBase {

    AOETestPage aoeTestPage;


    @Test
    public void recruiterTest() throws InterruptedException {
        extendlogger = report.createTest("AOE Recruiter Test");
        aoeTestPage = new AOETestPage(driver);
        extendlogger.info("Accept button clicked");
        aoeTestPage.cookieBtn.click();

        Thread.sleep(1000);
        BrowserUtils.hover(aoeTestPage.careerBtn);

        extendlogger.info("Navigated to the ‘Vacancies’ page ");
        aoeTestPage.vacanciesBtn.click();

        extendlogger.info("‘frontend’ as keyword filtered ");
        aoeTestPage.keywordBtn.sendKeys("frontend");

       // System.out.println("aoeTestPage.offeringList().get(0) = " + aoeTestPage.offeringList().get(0));

        extendlogger.info("Filtered Frontend search verified");
        Assert.assertTrue(aoeTestPage.offeringList().get(0).contains("Frontend"));

        extendlogger.info("Clicked the first entry which is displayed.");
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",aoeTestPage.offering(aoeTestPage.offeringList().get(0)));

        extendlogger.info("Content of this job offering is being displayed");
        String expectedText="Frontend / React Developer (m/f/d), remote possible (headquarters in Wiesbaden)";
        String actualText=aoeTestPage.verifyOption.getText().trim();
        Assert.assertEquals(expectedText,actualText);







    }
}
