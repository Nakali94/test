package vse.p4it478.r2017.ls.cv.template.browser.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends CommonPage {

	/*@FindBy(css = "#wysiwyg table td a[rel=\"bookmark\"]")
	protected List<WebElement> firstResultEls;*/

	@FindBy(css = "#pole div.left div.searched h2 strong")
	protected WebElement searchElKontakty;
	
	@FindBy(css = "#pole div.left div.searched div a")
	protected WebElement searchElKontaktyLink;
	
	
	/*public WebElement getFirstResultEl() {
		return firstResultEls.stream().filter(el -> el.getAttribute("href").startsWith(getBaseUrl())).findAny()
				.orElseThrow(() -> new BrowserException("Found no search result which starts with " + getBaseUrl()));
	}

	public String getFirstResultTitle() {
		return getFirstResultEl().getText().trim();
	}*/

	public String getFirstResultTitleKontakty() {
		return searchElKontakty.getText().trim();
	}
	
	/*public CommonPage goToFirstResult() {
		getFirstResultEl().click();
		return browser.initPage(new CommonPage());
	}*/
	
	public CommonPage goToFirstResultKontakty() {
		searchElKontaktyLink.click();
		return browser.initPage(new CommonPage());
	}


}
