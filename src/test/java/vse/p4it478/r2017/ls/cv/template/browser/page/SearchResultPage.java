package vse.p4it478.r2017.ls.cv.template.browser.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import vse.p4it478.r2017.ls.cv.template.browser.BrowserException;

public class SearchResultPage extends CommonPage {

	@FindBy(css = "#wysiwyg table td a[rel=\"bookmark\"]")
	protected List<WebElement> firstResultEls;

	public WebElement getFirstResultEl() {
		return firstResultEls.stream().filter(el -> el.getAttribute("href").startsWith(getBaseUrl())).findAny()
				.orElseThrow(() -> new BrowserException("Found no search result which starts with " + getBaseUrl()));
	}

	public String getFirstResultTitle() {
		return getFirstResultEl().getText().trim();
	}

	public CommonPage goToFirstResult() {
		getFirstResultEl().click();
		return browser.initPage(new CommonPage());
	}

}
