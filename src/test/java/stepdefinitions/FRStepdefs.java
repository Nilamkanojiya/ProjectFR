package stepdefinitions;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.FormA_applicationPage;
import pages.LoginPage;
import pages.ManageCasePage;

public class FRStepdefs extends BaseClass {

//        @Given("(.*) login to hmcts")
//        public void solicitorLogin(String user) throws InterruptedException {
//            launchPlaywright("chromium", "false", 1000);
//            launchApplication("https://manage-case.aat.platform.hmcts.net/");
//            LoginPage loginPage = new LoginPage(page);
//            loginPage.login(user);
//            ManageCasePage manageCasePage = new ManageCasePage(page);
//            manageCasePage.createContestedCase();
//            FormA_applicationPage formAApplicationPage = new FormA_applicationPage(page);
//            formAApplicationPage.fillSolicitorDetails();
//            formAApplicationPage.divorceDetail();
//            formAApplicationPage.applicantDetails();
//            formAApplicationPage.respondentDetails();
//            formAApplicationPage.respondentNotRepresented();
//            formAApplicationPage.natureOfApplicationQ();
//            formAApplicationPage.fastTrackApplication();
//            formAApplicationPage.otherQuestion();
//            formAApplicationPage.courtSelection();
//            formAApplicationPage.miamQuestion();
//            formAApplicationPage.miamDetails();
//            formAApplicationPage.uploadOtherDocument();
//            formAApplicationPage.savingApplication();
//            formAApplicationPage.submitApplication();
//            closePlaywright();
//        }

    @When("{string} creates a case")
    public void creates_a_case(String user) {
        ManageCasePage manageCasePage = new ManageCasePage(page);
        manageCasePage.createContestedCase();
    }

    @When("{string} fills form A application")
    public void FillFormAApplication(String user) throws InterruptedException {
        FormA_applicationPage formAApplicationPage = new FormA_applicationPage(page);
        formAApplicationPage.fillSolicitorDetails();
        formAApplicationPage.divorceDetail();
        formAApplicationPage.applicantDetails();
        formAApplicationPage.respondentDetails();
        formAApplicationPage.respondentNotRepresented();
        formAApplicationPage.natureOfApplicationQ();
        formAApplicationPage.fastTrackApplication();
        formAApplicationPage.otherQuestion();
        formAApplicationPage.courtSelection();
        formAApplicationPage.miamQuestion();
        formAApplicationPage.miamDetails();
        formAApplicationPage.uploadOtherDocument();
        formAApplicationPage.savingApplication();
        formAApplicationPage.submitApplication();
        closePlaywright();
    }

    @Given("{string} login to hmcts")
        public void login_to_hmcts(String user) throws InterruptedException {
            launchPlaywright("chromium", "false", 1000);
            launchApplication("https://manage-case.aat.platform.hmcts.net/");
            LoginPage loginPage = new LoginPage(page);
            loginPage.login(user);


    }

}
