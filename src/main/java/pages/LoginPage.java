package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {

    private final Page page;

    String email = "fr_applicant_solicitor1@mailinator.com";
    String password = "Testing1234";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void login() {
        boolean isLoginSuccess = false;
        page.getByLabel("Email address").fill(email);
        page.getByLabel("Password").fill(password);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click();
        page.waitForLoadState(LoadState.LOAD);
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases");


//        boolean isEnabled = page.isEnabled("input");
//        if (isEnabled) {
//            isLoginSuccess = true;
//        }
//        return isLoginSuccess;

    }
}


