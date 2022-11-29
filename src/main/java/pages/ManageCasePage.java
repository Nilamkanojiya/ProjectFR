package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ManageCasePage {

    private final Page page;

    public ManageCasePage(Page page) {
        this.page = page;
    }

    public void createContestedCase(){
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create case")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-filter");
        Locator dropdown = page.locator("#cc-jurisdiction");
        dropdown.click();

        while (dropdown.count()< 0 )  {
            dropdown.click();
        }

        dropdown.selectOption("DIVORCE");
        page.locator("#cc-case-type").selectOption("FinancialRemedyContested");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate1");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate2");

    }

    public void createContestedCaseViaCaseWorker(){
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create case")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-filter");
        Locator dropdown = page.locator("#cc-jurisdiction");
        dropdown.click();

        while (dropdown.count()< 0 )  {
            dropdown.click();
        }

        dropdown.selectOption("DIVORCE");
        page.locator("#cc-case-type").selectOption("FinancialRemedyContested");
        page.locator("#cc-event").selectOption("FR_solicitorCreate");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate1");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate2");

    }
}
