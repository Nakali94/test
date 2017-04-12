package vse.p4it478.r2017.ls.cv.template.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends CommonPage {

	protected By firstResultSelector = By.cssSelector("#wysiwyg table td a[rel=\"bookmark\"]");

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getFirstResultEl() {
		return driver.findElements(firstResultSelector).stream()
				.filter(el -> el.getAttribute("href").startsWith(BASE_URL)).findAny()
				.orElseThrow(() -> new RuntimeException("Found no search result which starts with " + BASE_URL));
	}

	public String getFirstResultTitle() {
		return getFirstResultEl().getText().trim();
	}

	public CommonPage goToFirstResult() {
		getFirstResultEl().click();
		return new CommonPage(driver);
	}

}
