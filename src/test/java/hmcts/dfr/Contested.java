package hmcts.dfr;

import base.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FormA_applicationPage;
import pages.LoginPage;
import pages.ManageCasePage;


public class Contested extends BaseClass {


   @BeforeClass
   public  void browserStart() {
      launchPlaywright("chromium", "false", 1000);
      launchApplication("https://manage-case.aat.platform.hmcts.net/");
   }


   @Test
   public void contestedE2ESolicitor() throws InterruptedException {
      String user = "solicitor";
      LoginPage loginPage = new LoginPage(page);
      loginPage.login(user);
      ManageCasePage manageCasePage = new ManageCasePage(page);
      manageCasePage.createContestedCase();
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
   }

   @Test
   public void contestedE2ECaseWorker() throws InterruptedException {
      String user = "case worker";
      boolean applicantRepresent = true;
      LoginPage loginPage = new LoginPage(page);
      loginPage.login(user);
      ManageCasePage manageCasePage = new ManageCasePage(page);
      manageCasePage.createContestedCaseViaCaseWorker();
      FormA_applicationPage formAApplicationPage = new FormA_applicationPage(page);
      formAApplicationPage.formAApplicationQ(applicantRepresent);
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
   }

   @AfterClass
   public void cleanUp(){
      closePlaywright();
   }






                    }

