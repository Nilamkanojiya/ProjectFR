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


    public void fillSolicitorDetails(){
        page.getByLabel("Solicitor’s name").click();
        page.getByLabel("Solicitor’s name").fill("Naomi Woodard");
        page.getByLabel("You can only search for organisations already registered with MyHMCTS. For example, you can search by organisation name or address.").click();
        page.getByLabel("You can only search for organisations already registered with MyHMCTS. For example, you can search by organisation name or address.").fill("finrem-1");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Select")).click();
        page.getByLabel("Solicitor’s firm").click();
        page.getByLabel("Solicitor’s firm").fill("Tran and Parks Plc");
        page.getByLabel("Your reference number").click();
        page.getByLabel("Your reference number").fill("1122");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter a UK postcode")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter a UK postcode")).fill("lu1 2al");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Find address")).click();
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Select an address")).selectOption("2: Object");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone Number")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone Number")).fill("12345678");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email")).fill("fr_applicant_solicitor1@mailinator.com");
        page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Yes")).check();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate3");

    }

    public void divorceDetail(){
        page.getByLabel("Divorce / Dissolution Case Number").click();
        page.getByLabel("Divorce / Dissolution Case Number").fill("lv12d12345");
        page.getByRole(AriaRole.GROUP, new Page.GetByRoleOptions().setName("Date of marriage / civil partnership")).getByLabel("Day").fill("1");
        page.getByRole(AriaRole.GROUP, new Page.GetByRoleOptions().setName("Date of marriage / civil partnership")).getByLabel("Month").fill("1");
        page.getByRole(AriaRole.GROUP, new Page.GetByRoleOptions().setName("Date of marriage / civil partnership")).getByLabel("Year").fill("2021");
        page.getByRole(AriaRole.GROUP, new Page.GetByRoleOptions().setName("Application Issued Date")).getByLabel("Day").fill("1");
        page.getByRole(AriaRole.GROUP, new Page.GetByRoleOptions().setName("Application Issued Date")).getByLabel("Month").fill("1");
        page.getByRole(AriaRole.GROUP, new Page.GetByRoleOptions().setName("Application Issued Date")).getByLabel("Year").fill("2022");
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("What stage has the divorce / dissolution case reached ?")).selectOption("1: Petition Issued");
        page.getByLabel("Name of Court / Divorce Centre where petition issued").click();
        page.getByLabel("Name of Court / Divorce Centre where petition issued").fill("watford court");
        // page.getByLabel("Upload Petition").click();
        page.getByLabel("Upload Petition").setInputFiles(Paths.get("Files/scratch.txt"));
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate4");


    }

    public void applicantDetails(){
        page.getByLabel("Current First and Middle names").click();
        page.getByLabel("Current First and Middle names").fill("Mr bean");
        page.getByLabel("Current Last Name").click();
        page.getByLabel("Current Last Name").fill("smith");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate5");

    }

    public void respondentDetails(){
        page.getByLabel("Current First and Middle names").click();
        page.getByLabel("Current First and Middle names").fill("Mrs kate");
        page.getByLabel("Current Last Name").click();
        page.getByLabel("Current Last Name").fill("smith");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate6");


    }

    public void respondentNotRepresented() {
        page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("No")).check();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter a UK postcode")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter a UK postcode")).fill("lu40ht");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Find address")).click();
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Select an address")).selectOption("1: Object");
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
        page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("No")).check();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate12");

    }

    public void otherQuestion(){
        page.getByLabel("I Don't Know").check();
        page.getByLabel("£1 - £5 million").check();
        page.locator("#netValueOfHome").click();
        page.locator("#netValueOfHome").fill("1000000");
        page.getByLabel("Not applicable").check();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate13");


    }

    public void courtSelection(){
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Please choose the Region in which the Applicant resides")).selectOption("1: wales");
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("If the FRC is not on the pilot, your application cannot proceed online. Please make a paper application direct to the FRC.")).selectOption("1: northwales");
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Where is the Applicant’s Local Court?")).selectOption("2: FR_northwalesList_4");
        page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("No")).check();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate15");


    }

    public void miamQuestion(){

        page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Yes")).check();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate21");

    }

    public void miamDetails(){
        page.getByLabel("Mediator Registration Number (URN)").click();
        page.getByLabel("Mediator Registration Number (URN)").fill("1122");
        page.getByLabel("Family Mediation Service Name").click();
        page.getByLabel("Family Mediation Service Name").fill("apex service");
        page.getByLabel("Sole Trader Name").click();
        page.getByLabel("Sole Trader Name").fill("Apex ltd");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate23");

    }


    public void uploadOtherDocument() {
        page.getByLabel("No").check();
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
        page.navigate("https://manage-case.aat.platform.hmcts.net/cases/case-details/1669160249001746");
        page.navigate("https://manage-case.aat.platform.hmcts.net/cases/case-details/1669160249001746#History");

    }
}
