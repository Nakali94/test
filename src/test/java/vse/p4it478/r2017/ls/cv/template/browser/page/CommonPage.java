package vse.p4it478.r2017.ls.cv.template.browser.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vse.p4it478.r2017.ls.cv.template.browser.Page;
import vse.p4it478.r2017.ls.cv.template.browser.marker.WithSearch;
import vse.p4it478.r2017.ls.cv.template.browser.marker.WithSpojeniSearch;
import vse.p4it478.r2017.ls.cv.template.browser.module.SearchModule;
import vse.p4it478.r2017.ls.cv.template.browser.module.SpojeniModule;

public class CommonPage extends Page implements WithSearch, WithSpojeniSearch {

	/*@FindBy(css = "#leftcontent .leftcontent-main .menu li a")
	protected WebElement menuItemEl;

	@FindBy(css = "select.text")
	protected WebElement quickNavigationEl;*/

	@FindBy(css = "form[id=hledani]")
	protected WebElement searchModuleEl;
	
	@FindBy(css = "form[id=route]")
	protected WebElement spojeniModuleEl;

	@FindBy(css = "a.kontakty-dpp")
	protected WebElement menuItemElKontakty;
	
	
	/*public String getFirstMenuItemTitle() {
		return menuItemEl.getText().trim();
	}

	
	public CommonPage goToFirstMenuItem() {
		menuItemEl.click();
		return browser.initPage(new CommonPage());
	}*/

	
	public String getMenuItemElKontakty() {
		return menuItemElKontakty.getText().trim();
	}
		
	
	public CommonPage goToMenuItemElKontakty() {
		menuItemElKontakty.click();
		return browser.initPage(new CommonPage());
	}
	
	@Override
	public SearchResultPage search(String text) {
		return browser.initModule(new SearchModule(), searchModuleEl).search(text);
	}
	
	@Override
	public SpojeniResultPage search(String odkud, String kam, String cas) {
		return browser.initModule(new SpojeniModule(), spojeniModuleEl).search(odkud, kam, cas);
	}
	
	public WebElement getSpojeniModulEl(){
		return spojeniModuleEl;
	}

	/*public void quickNavigateByValue(String value) {
		new Select(quickNavigationEl).selectByValue(value);
	}*/

	@Override
	public String getUri() {
		return null;
	}

}
