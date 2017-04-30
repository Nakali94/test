package vse.p4it478.r2017.ls.cv.template.test.browser;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

import ru.yandex.qatools.allure.annotations.Attachment;
import vse.p4it478.r2017.ls.cv.template.browser.Browser;
import vse.p4it478.r2017.ls.cv.template.browser.BrowserException;
import vse.p4it478.r2017.ls.cv.template.browser.logic.SearchLogic;
import vse.p4it478.r2017.ls.cv.template.browser.logic.SpojeniLogic;
import vse.p4it478.r2017.ls.cv.template.browser.module.RegisterModule;
import vse.p4it478.r2017.ls.cv.template.browser.module.SpojeniModule;
import vse.p4it478.r2017.ls.cv.template.browser.page.HomePage;
import vse.p4it478.r2017.ls.cv.template.browser.page.RegisterPage;
import vse.p4it478.r2017.ls.cv.template.browser.page.SearchResultPage;
import vse.p4it478.r2017.ls.cv.template.browser.page.SpojeniResultPage;
import vse.p4it478.r2017.ls.cv.template.driver.DriverManager;



public class BrowserTest {

	private Browser browser;

	@Before
	public void setUp() throws Exception {
		browser = new Browser();
		browser.addProperties("browser.properties", true).addProperties(System.getProperties());
		String driverProp = browser.getProperty("driver");
		if (driverProp == null)
			throw new BrowserException("Property driver is required.");
		WebDriver driver;
		switch (driverProp) {
		case BrowserType.PHANTOMJS:
			driver = DriverManager.createPhantomJSDriver(browser);
			break;
		case BrowserType.CHROME:
			driver = DriverManager.createChromeDriver(browser);
			break;
		case "remote":
			driver = DriverManager.createRemoteWebDriver(browser);
			break;
		default:
			throw new BrowserException("Property driver has unknown value: " + driverProp + ".");
		}
		browser.setDriver(driver);
	}
	
	@Test
	public void searchtest() throws Exception {
		HomePage homePage = browser.loadPage(new HomePage());
		String menuItemElKontakty = homePage.getMenuItemElKontakty();
		homePage.goToMenuItemElKontakty();
		assertTrue("Menu item Kontakty contains title " + menuItemElKontakty,
				browser.getDriver().getTitle().contains(menuItemElKontakty));
		SearchResultPage searchResultPage = browser.initLogic(new SearchLogic())
				.search(browser.getProperty("searchTextDPP"));
		String searchElKontakty = searchResultPage.getFirstResultTitleKontakty();
		assertEquals(searchElKontakty, browser.getProperty("searchTextDPP"));
		String url = browser.getDriver().getCurrentUrl();
		searchResultPage.goToFirstResultKontakty();
		assertNotSame("URL is changed after click to link" + url, browser.getDriver().getCurrentUrl());
		
	}
	
	@Test
	public void vyhledavaniSpojeniTest() throws Exception {
		HomePage homePage = browser.loadPage(new HomePage());
		SpojeniModule spojeniModule = browser.initModule(new SpojeniModule()/*, homePage.getSpojeniModulEl()*/);
		SpojeniResultPage spojeniResultPage = spojeniModule.search(browser.getProperty("odkud"),browser.getProperty("kam"), browser.getProperty("cas"));
		assertTrue("Vyhledavani odpovida zadane trase " + browser.getProperty("odkud") +" - " + browser.getProperty("kam"),
				spojeniResultPage.getH1().contains(browser.getProperty("odkud")+" - "+browser.getProperty("kam")));		
	}
	
	@Test
	public void naseptavacSpojeniTest() throws Exception {
		HomePage homePage = browser.loadPage(new HomePage());
		SpojeniModule spojeniModule = browser.initModule(new SpojeniModule()/*, homePage.getSpojeniModulEl()*/);
		assertTrue("V naseptavaci se zobrazila vyhledavana polozka " + browser.getProperty("odkud"),
				spojeniModule.getNaseptavacResult(browser.getProperty("odkud")).contains(browser.getProperty("odkud")));
	}
	
	@Test
	public void prohoditSpojeniTest() throws Exception {
		HomePage homePage = browser.loadPage(new HomePage());
		SpojeniModule spojeniModule = browser.initModule(new SpojeniModule()/*, homePage.getSpojeniModulEl()*/);
		spojeniModule.clickVyhledavaniSpojeniProhodit(browser.getProperty("odkud"), browser.getProperty("kam"));	
		assertFalse("Po prohozeni neni v odkud "+browser.getProperty("odkud"),
				spojeniModule.getVyhledavaniSpojeniOdkud().contains(browser.getProperty("odkud")));
		assertFalse("Po prohozeni neni v kam "+browser.getProperty("kam"),
				spojeniModule.getVyhledavaniSpojeniKam().contains(browser.getProperty("kam")));
	}
	
	@Test
	public void spojeniDatumTest() throws Exception {
		DateFormat df = new SimpleDateFormat("d.M.yyyy");
		Date dateobj = new Date();
		System.out.println(df.format(dateobj));
		HomePage homePage = browser.loadPage(new HomePage());
		SpojeniModule spojeniModule = browser.initModule(new SpojeniModule(), homePage.getSpojeniModulEl());	
		System.out.println(spojeniModule.getVyhledavaniSpojeniDatum());
		assertEquals("Převyplněné datum je dnešní",
				spojeniModule.getVyhledavaniSpojeniDatum(), df.format(dateobj));
	}
	
	@Test
	  public void testRegistraceNegativni() throws Exception {
		HomePage homePage = browser.loadPage(new HomePage());
		homePage.goToRegistration();
		RegisterModule registerModule = browser.initModule(new RegisterModule());
		RegisterPage registerPage = registerModule.register("aaatester", "tester@test.cz", "765567765", "Password543", "heslo");
		assertTrue("Na stránce je zobrazena hláška o nevalidním heslu: ", registerPage.getRegisterErrorText().contains("Pole \"Heslo\" nebylo možné ověřit."));  
	  }


	@After
	public void tearDown() throws Exception {
		if (browser != null) {
			if (browser.getDriver() != null) {
				saveScreenshot();
				saveSource();
			}
			browser.quit();
		}
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
