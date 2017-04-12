package vse.p4it478.r2017.ls.cv.template.pagefactory.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends CommonPage {

	@FindBy(css = "#wysiwyg table td a[rel=\"bookmark\"]")
	protected List<WebElement> firstResultEls;

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getFirstResultEl() {
		return firstResultEls.stream().filter(el -> el.getAttribute("href").startsWith(BASE_URL)).findAny()
				.orElseThrow(() -> new RuntimeException("Found no search result which starts with " + BASE_URL));
	}

	public String getFirstResultTitle() {
		return getFirstResultEl().getText().trim();
	}

	public CommonPage goToFirstResult() {
		getFirstResultEl().click();
		return PageFactory.initElements(driver, CommonPage.class);
	}

}
