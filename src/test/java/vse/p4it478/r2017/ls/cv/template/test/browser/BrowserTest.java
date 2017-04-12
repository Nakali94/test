package vse.p4it478.r2017.ls.cv.template.test.browser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ru.yandex.qatools.allure.annotations.Attachment;
import vse.p4it478.r2017.ls.cv.template.browser.Browser;
import vse.p4it478.r2017.ls.cv.template.browser.logic.SearchLogic;
import vse.p4it478.r2017.ls.cv.template.browser.page.CommonPage;
import vse.p4it478.r2017.ls.cv.template.browser.page.HomePage;
import vse.p4it478.r2017.ls.cv.template.browser.page.SearchResultPage;
import vse.p4it478.r2017.ls.cv.template.driver.ChromeDriverManager;

public class BrowserTest {
	
	private Browser browser;

	@Before
	public void setUp() throws Exception {
		browser = new Browser();
		browser.addProperties("browser.properties", true).addProperties(System.getProperties())
				.setDriver(ChromeDriverManager.create());
	}

	@Test
	public void test() throws Exception {
		HomePage homePage = browser.loadPage(new HomePage());
		String firstMenuItemTitle = homePage.getFirstMenuItemTitle();
		homePage.goToFirstMenuItem();
		assertTrue("First menu item page contains title " + firstMenuItemTitle,
				browser.getDriver().getTitle().contains(firstMenuItemTitle));

		SearchResultPage searchResultPage = browser.initLogic(new SearchLogic())
				.search(browser.getProperty("searchText"));
		String firstSearchResultTitle = searchResultPage.getFirstResultTitle();
		searchResultPage.goToFirstResult();
		assertTrue("First search result page contains title " + firstSearchResultTitle,
				browser.getDriver().getTitle().contains(firstSearchResultTitle));

		String url = browser.getDriver().getCurrentUrl();
		String value = browser.getProperty("quickNavigationValue");
		browser.getPage(CommonPage.class).quickNavigateByValue(value);
		assertNotSame("URL is changed after quick navigation to " + value, url, browser.getDriver().getCurrentUrl());
	}
	
	@Test
	public void failedTest() throws Exception {
		HomePage homePage = browser.loadPage(new HomePage());
		String firstMenuItemTitle = homePage.getFirstMenuItemTitle();
		homePage.goToFirstMenuItem();
		assertFalse("First menu item page does not contain title " + firstMenuItemTitle,
				browser.getDriver().getTitle().contains(firstMenuItemTitle));
	}
	
	@After
	public void tearDown() throws Exception {
		saveScreenshot();
		saveSource();
		browser.quit();
	}
	
	@Attachment(value = "Page screenshot", type = "image/png")
	private byte[] saveScreenshot() {
	    return ((TakesScreenshot) browser.getDriver()).getScreenshotAs(OutputType.BYTES);
	}
	
	@Attachment(value = "Page source", type = "text/html")
	private String saveSource() {
	    return browser.getDriver().getPageSource();
	}

}
