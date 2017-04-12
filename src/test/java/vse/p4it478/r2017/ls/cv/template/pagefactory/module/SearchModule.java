package vse.p4it478.r2017.ls.cv.template.pagefactory.module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vse.p4it478.r2017.ls.cv.template.pagefactory.page.SearchResultPage;

public class SearchModule {

	protected WebDriver driver;

	protected WebElement element;

	@FindBy(id = "s")
	protected WebElement searchInputEl;

	@FindBy(css = "input.submit")
	protected WebElement searchButtonEl;

	public SearchModule(WebDriver driver, WebElement element) {
		this.driver = driver;
		this.element = element;
	}

	public SearchResultPage search(String text) {
		searchInputEl.clear();
		searchInputEl.sendKeys(text);
		searchButtonEl.click();
		return PageFactory.initElements(driver, SearchResultPage.class);
	}

}
