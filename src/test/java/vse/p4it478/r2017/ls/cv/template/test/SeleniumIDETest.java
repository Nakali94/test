package vse.p4it478.r2017.ls.cv.template.test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import vse.p4it478.r2017.ls.cv.template.driver.ChromeDriverManager;

public class SeleniumIDETest {

	private WebDriver driver;

	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = ChromeDriverManager.create();
		baseUrl = "http://kit.vse.cz/";
	}

	@Test
	public void test() throws Exception {
		driver.get(baseUrl);

		WebElement firstMenuItemHrefEl = driver
				.findElement(By.cssSelector("#leftcontent .leftcontent-main .menu li a"));
		String firstMenuItemTitle = firstMenuItemHrefEl.getText().trim();
		firstMenuItemHrefEl.click();
		assertTrue("First menu item page contains title " + firstMenuItemTitle,
				driver.getTitle().contains(firstMenuItemTitle));

		driver.findElement(By.id("s")).clear();
		driver.findElement(By.id("s")).sendKeys("4it478");
		driver.findElement(By.cssSelector("input.submit")).click();

		WebElement firstSearchResultHrefEl = driver
				.findElements(By.cssSelector("#wysiwyg table td a[rel=\"bookmark\"]")).stream()
				.filter(el -> el.getAttribute("href").startsWith(baseUrl)).findAny()
				.orElseThrow(() -> new RuntimeException("Found no search result which starts with " + baseUrl));
		String firstSearchResultTitle = firstSearchResultHrefEl.getText().trim();
		firstSearchResultHrefEl.click();
		assertTrue("First search result page contains title " + firstSearchResultTitle,
				driver.getTitle().contains(firstSearchResultTitle));

		String url = driver.getCurrentUrl();
		String value = "http://www.vse.cz/zdroje/";
		new Select(driver.findElement(By.cssSelector("select.text"))).selectByValue(value);
		assertNotSame("URL is changed after quick navigation to " + value, url, driver.getCurrentUrl());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
