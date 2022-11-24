package pages;

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

        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Jurisdiction")).click();
        int options =page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Jurisdiction")).count();

        while (options< 0 )  {
            page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Jurisdiction")).click();
        }

        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Jurisdiction")).selectOption("DIVORCE");

        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Case type")).selectOption("FinancialRemedyContested");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate1");

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases/case-create/DIVORCE/FinancialRemedyContested/FR_solicitorCreate/FR_solicitorCreate2");

    }
}
