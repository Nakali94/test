package vse.p4it478.r2017.ls.cv.template.pageobject.module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import vse.p4it478.r2017.ls.cv.template.pageobject.page.SearchResultPage;

public class SearchModule {

	protected WebDriver driver;

	protected WebElement element;

	protected By searchInputSelector = By.id("s");

	protected By searchButtonSelector = By.cssSelector("input.submit");

	public SearchModule(WebDriver driver, WebElement element) {
		this.driver = driver;
		this.element = element;
	}

	public SearchResultPage search(String text) {
		WebElement searchInputEl = element.findElement(searchInputSelector);
		searchInputEl.clear();
		searchInputEl.sendKeys(text);
		element.findElement(searchButtonSelector).click();
		return new SearchResultPage(driver);
	}

}
