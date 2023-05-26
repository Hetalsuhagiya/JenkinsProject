package org.example;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest{
    HomePage homePage = new HomePage();
    RegistrationFormPage registrationPage = new RegistrationFormPage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();
    @Test
    public void verifyUserShouldBeRegisterSuccessfully(){
        //click on register
        homePage.clickOnRegisterButton();
        //fill in registration form
        registrationPage.enterRegistrationDetails1();
        //confirm registration
        registrationResultPage.verifyUserRegisteredSuccessfullyOrNot();
    }
    @Test
    public void verifyNonRegisteredUserCanNotVote() {
        //click on Good button
        homePage.clickOnGood();
        //click on vote button
        homePage.clickOnVote();
        //verify message that non-registered user can not vote
        homePage.verifyNonRegisteredUserCanNotVote();
    }


}
