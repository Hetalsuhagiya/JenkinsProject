package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage extends Utils {
    private By _registerButton = By.xpath("//a[text()='Register']");
    private By _communityPollAnswers = By.xpath("//label[@for='pollanswers-2']");
    private By _votePoll = By.xpath("//button[@id='vote-poll-1']");
    private By _pollVoteError = By.xpath("//div[contains(@class,'poll-vote-error')]");
    String expectedMessage1 = "Only registered users can vote.";
    public void clickOnRegisterButton() {
        clickOnElement(_registerButton);
    }

    public void clickOnGood() {
        //click on Good on community poll
        clickOnElement(_communityPollAnswers);
    }
    public void clickOnVote() {
        clickOnElement(_votePoll);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("block-poll-vote-error-1")));
    }

    public void verifyNonRegisteredUserCanNotVote() {
        //get text from element
        String message = getTextFromElement(_pollVoteError);
        System.out.println("My message: " + message);
        Assert.assertEquals(message, expectedMessage1, "voting eligibility message is not correct");
    }
}