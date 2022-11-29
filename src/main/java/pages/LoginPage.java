package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {
    private static Logger logger = LoggerFactory.getLogger(LoginPage.class);
    private final Page page;
    String username = "#username";
    String password = "#password";
    String solicitorUser = "fr_applicant_solicitor1@mailinator.com";
    String solicitorPassword = "Testing1234";
    String caseWorkerUser = "claire_fr_mumford@yahoo.com";
    String caseWorkerPassword = "Nagoya0102";
    String judgeUser = "peter_fr_chapman@yahoo.com";
    String judgePassword = "Nagoya0102";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void login(String user) {
     //boolean isLoginSuccess = false;
        if (user.equalsIgnoreCase("solicitor")) {
            page.fill(username,solicitorUser);
            page.fill(password, solicitorPassword);
        } else if (user.equalsIgnoreCase("case worker")) {
            page.fill(username,caseWorkerUser);
            page.fill(password, caseWorkerPassword);
        } else if (user.equalsIgnoreCase("judge")){
            page.fill(username,judgeUser);
            page.fill(password, judgePassword);
        } else {
            logger.info("Please provide valid user credential");
        }
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click(); //can replace with xpath too
        page.waitForLoadState(LoadState.LOAD);
        //TODO add 5 second wait or check page loading correct
        if (user.equalsIgnoreCase("solicitor")){
            page.waitForSelector("#wb-jurisdiction", new Page.WaitForSelectorOptions().setTimeout(10000));
        } else {
        page.waitForSelector("#caseReference", new Page.WaitForSelectorOptions().setTimeout(10000));
        }

        if (user.equalsIgnoreCase("solicitor")) {
        assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/cases");
        } else if (user.equalsIgnoreCase("case worker")){
            assertThat(page).hasURL("https://manage-case.aat.platform.hmcts.net/work/my-work/list");
        }
        // TODO - else if(){}
        else {
            logger.info("Please provide valid user credential");
        }

//        boolean isEnabled = page.isEnabled("input");
//        if (isEnabled) {
//            isLoginSuccess = true;
//        }
//        return isLoginSuccess;

    }
}


