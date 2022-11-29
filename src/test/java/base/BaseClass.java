package base;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BaseClass {
    Playwright playwright;
    BrowserType browserType;
    Browser browser;
    BrowserContext context;
    protected Page page;

    private static Logger logger = LoggerFactory.getLogger(BaseClass.class);

    public void launchPlaywright(String browserName, String headless, double sloMo){
        playwright = Playwright.create();
        if (browserName.equalsIgnoreCase("chrome") || browserName.equalsIgnoreCase("chromium")) {
            browserType = playwright.chromium();
        } else if ( browserName.equalsIgnoreCase("webkit")) {
            browserType = playwright.webkit();
        }

        if(headless.equalsIgnoreCase("true")){
            browser = browserType.launch(new BrowserType.LaunchOptions().setChannel(browserName).setHeadless(true).setSlowMo(sloMo));
        } else if (headless.equalsIgnoreCase("false")) {

            browser = browserType.launch(new BrowserType.LaunchOptions().setChannel(browserName).setHeadless(false).setSlowMo(sloMo));
        }

        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,1080));
       // context.close();
        page = context.newPage();
        logger.info("Browser Name is:" +browserName);

    }

    public  void  launchApplication(String url){
        page.navigate(url, new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
    }

    public void closePlaywright(){
        page.close();
        browser.close();
        playwright.close();
    }
}
