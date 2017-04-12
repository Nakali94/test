package vse.p4it478.r2017.ls.cv.template.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import vse.p4it478.r2017.ls.cv.template.pageobject.module.SearchModule;

public class CommonPage {

	public static final String BASE_URL = "http://kit.vse.cz/";

	protected WebDriver driver;

	protected By menuItemSelector = By.cssSelector("#leftcontent .leftcontent-main .menu li a");

	protected By quickNavigationSelector = By.cssSelector("select.text");

	protected By searchModuleSelector = By.cssSelector("form[name=search]");

	public CommonPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getFirstMenuItemTitle() {
		return driver.findElement(menuItemSelector).getText().trim();
	}

	public CommonPage goToFirstMenuItem() {
		driver.findElement(menuItemSelector).click();
		return new CommonPage(driver);
	}

	public SearchResultPage search(String text) {
		return new SearchModule(driver, driver.findElement(searchModuleSelector)).search(text);
	}

	public void quickNavigateByValue(String value) {
		new Select(driver.findElement(quickNavigationSelector)).selectByValue(value);
	}

}
