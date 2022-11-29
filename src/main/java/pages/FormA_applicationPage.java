package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import java.nio.file.Paths;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FormA_applicationPage {
    private final Page page;

    public FormA_applicationPage(Page page) {
        this.page = page;
    }

    public void formAApplicationQ(boolean applicantRepresent){
        if (applicantRepresent) {
        page.locator("#applicantRepresented_Yes").check();
        } else {
            page.locator("#applicantRepresented_No").check();
        }
    }

    public void fillSolicitorDetails(){
        page.locator("#applicantSolicitorName").fill("Naomi Woodard");
        page.locator("#search-org-text").fill("finrem-1");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Select")).click();

        page.locator("#applicantSolicitorFirm").fill("Tran and Parks Plc");
        page.locator("#solicitorReference").fill("1122");

        page.locator("#applicantSolicitorAddress_applicantSolicitorAddress_postcodeInput").fill("LU1 2AL");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Find address")).click();

        page.locator("#applicantSolicitorAddress_applicantSolicitorAddress_addressList").selectOption("2: Object");

        page.locator("#applicantSolicitorPhone").fill("12345678");
        page.locator("#applicantSolicitorEmail").fill("fr_applicant_solicitor1@mailinator.com");

        page.locator("#applicantSolicitorConsentForEmails_Yes").check();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate3");
    }

    public void divorceDetail() throws InterruptedException {
        page.locator("#divorceCaseNumber").fill("lv12d12345");
        page.locator("#dateOfMarriage-day").fill("1");
        page.locator("#dateOfMarriage-month").fill("1");
        page.locator("#dateOfMarriage-year").fill("2021");
        page.locator("#divorcePetitionIssuedDate-day").fill("1");
        page.locator("#divorcePetitionIssuedDate-month").fill("1");
        page.locator("#divorcePetitionIssuedDate-year").fill("2022");

        page.locator("#divorceStageReached").selectOption("1: Petition Issued");
        page.locator("#nameOfCourtDivorceCentre").fill("watford court");

        page.locator("#divorceUploadPetition").setInputFiles(Paths.get("Files/scratch.txt"));
        Thread.sleep(4000);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate4");
    }

    public void applicantDetails(){
        page.locator("#applicantFMName").fill("Mr bean");
        page.locator("#applicantLName").fill("smith");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate5");
    }

    public void respondentDetails(){
        page.locator("#respondentFMName").fill("Mrs kate");
        page.locator("#respondentLName").fill("smith");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate6");
    }

    public void respondentNotRepresented() {
        page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("No")).check();
        page.locator("#respondentAddress_respondentAddress_postcodeInput").fill("lu40ht");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Find address")).click();
        page.locator("#respondentAddress_respondentAddress_addressList").selectOption("1: Object");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate7");
    }

    public void natureOfApplicationQ(){
        page.getByLabel("Maintenance Pending Suit").check();
        page.getByLabel("Lump Sum Order").check();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate11");
    }

    public void fastTrackApplication() {
        page.locator("#fastTrackDecision_No").check();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate12");
    }

    public void otherQuestion(){
        page.locator("#addToComplexityListOfCourts-trueDontKnow").check();
        page.locator("#estimatedAssetsChecklist-estimatedAssetsChecklist_3").check();
        page.locator("#netValueOfHome").fill("1000000");
        page.locator("#potentialAllegationChecklist-notApplicable").check();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate13");
    }

    public void courtSelection(){
        page.locator("#regionList").selectOption("1: wales");
        page.locator("#walesFRCList").selectOption("1: northwales");
        page.locator("#northWalesCourtList").selectOption("2: FR_northwalesList_4");
        page.locator("#isApplicantsHomeCourt_No").check();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate15");
    }

    public void miamQuestion(){
        page.locator("#applicantAttendedMIAM_Yes").check();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate21");
    }

    public void miamDetails(){
        page.locator("#mediatorRegistrationNumber").fill("1122");
        page.locator("#familyMediatorServiceName").fill("apex service");
        page.locator("#soleTraderName").fill("Apex ltd");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate23");
    }


    public void uploadOtherDocument() {
        page.locator("#promptForAnyDocument_No").check();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate24");
    }

    public void savingApplication() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/submit");
    }

    public void submitApplication() {
        //TODO- write assertion
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
        page.navigate("https://manage-case.aat.platform.hmcts.net/cases/case-details/*");
    }
}
