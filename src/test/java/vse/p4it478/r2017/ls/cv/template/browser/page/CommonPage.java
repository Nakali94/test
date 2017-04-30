package vse.p4it478.r2017.ls.cv.template.browser.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vse.p4it478.r2017.ls.cv.template.browser.Page;
import vse.p4it478.r2017.ls.cv.template.browser.marker.WithSearch;
import vse.p4it478.r2017.ls.cv.template.browser.marker.WithSpojeniSearch;
import vse.p4it478.r2017.ls.cv.template.browser.marker.Register;
import vse.p4it478.r2017.ls.cv.template.browser.module.RegisterModule;
import vse.p4it478.r2017.ls.cv.template.browser.module.SearchModule;
import vse.p4it478.r2017.ls.cv.template.browser.module.SpojeniModule;


public class CommonPage extends Page implements WithSearch, WithSpojeniSearch, Register {

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
	
	@FindBy(css = "a[title=\"Zaregistrujte se a nastavte si stránky\"]")
	protected	WebElement linkRegistrace;
	
	
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
	
	/*
	 * Registrace
	 */
	public CommonPage goToRegistration(){
		linkRegistrace.click();
		return browser.initPage(new RegisterPage());
	}
	
	
	@Override
	public RegisterPage register(String nick, String email, String tel, String heslo, String hesloznov) {
		return browser.initModule(new RegisterModule(), linkRegistrace).register(nick, email, tel, heslo, hesloznov);
	}
	
	public WebElement getRegistrationLink(){
		return linkRegistrace;
	
	}

	/*public void quickNavigateByValue(String value) {
		new Select(quickNavigationEl).selectByValue(value);
	}*/

	@Override
	public String getUri() {
		return null;
	}

}
