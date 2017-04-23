package vse.p4it478.r2017.ls.cv.template.browser.module;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import vse.p4it478.r2017.ls.cv.template.browser.Module;
import vse.p4it478.r2017.ls.cv.template.browser.page.SearchResultPage;

public class SearchModule extends Module {

	@FindBy(id = "searchtext")
	protected WebElement searchInputEl;

	@FindBy(css = "input.uzky")
	protected WebElement searchButtonEl;

	public SearchResultPage search(String text) {
		searchInputEl.clear();
		searchInputEl.sendKeys(text);
		searchButtonEl.click();
		return browser.initPage(new SearchResultPage());
	}

}
