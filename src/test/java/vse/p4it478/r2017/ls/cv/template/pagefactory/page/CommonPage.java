package vse.p4it478.r2017.ls.cv.template.pagefactory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import vse.p4it478.r2017.ls.cv.template.pagefactory.module.SearchModule;

public class CommonPage {

	public static final String BASE_URL = "http://kit.vse.cz/";

	protected WebDriver driver;

	@FindBy(css = "#leftcontent .leftcontent-main .menu li a")
	protected WebElement menuItemEl;

	@FindBy(css = "select.text")
	protected WebElement quickNavigationEl;

	@FindBy(css = "form[name=search]")
	protected WebElement searchModuleEl;

	public CommonPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getFirstMenuItemTitle() {
		return menuItemEl.getText().trim();
	}

	public CommonPage goToFirstMenuItem() {
		menuItemEl.click();
		return PageFactory.initElements(driver, CommonPage.class);
	}

	public SearchResultPage search(String text) {
		SearchModule searchModule = new SearchModule(driver, searchModuleEl);
		PageFactory.initElements(new DefaultElementLocatorFactory(searchModuleEl), searchModule);
		return searchModule.search(text);
	}

	public void quickNavigateByValue(String value) {
		new Select(quickNavigationEl).selectByValue(value);
	}

}
