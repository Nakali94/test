package vse.p4it478.r2017.ls.cv.template.test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import vse.p4it478.r2017.ls.cv.template.driver.ChromeDriverManager;
import vse.p4it478.r2017.ls.cv.template.pagefactory.page.CommonPage;
import vse.p4it478.r2017.ls.cv.template.pagefactory.page.HomePage;
import vse.p4it478.r2017.ls.cv.template.pagefactory.page.SearchResultPage;

public class PageFactoryTest {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = ChromeDriverManager.create();
	}

	@Test
	public void test() throws Exception {
		driver.get(CommonPage.BASE_URL);

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		String firstMenuItemTitle = homePage.getFirstMenuItemTitle();
		CommonPage commonPage = homePage.goToFirstMenuItem();
		assertTrue("First menu item page contains title " + firstMenuItemTitle,
				driver.getTitle().contains(firstMenuItemTitle));

		SearchResultPage searchResultPage = commonPage.search("4it478");
		String firstSearchResultTitle = searchResultPage.getFirstResultTitle();
		commonPage = searchResultPage.goToFirstResult();
		assertTrue("First search result page contains title " + firstSearchResultTitle,
				driver.getTitle().contains(firstSearchResultTitle));

		String url = driver.getCurrentUrl();
		String value = "http://www.vse.cz/zdroje/";
		commonPage.quickNavigateByValue(value);
		assertNotSame("URL is changed after quick navigation to " + value, url, driver.getCurrentUrl());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}