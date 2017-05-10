package vse.p4it478.r2017.ls.cv.template.browser.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import vse.p4it478.r2017.ls.cv.template.browser.Page;
import vse.p4it478.r2017.ls.cv.template.browser.marker.Register;
import vse.p4it478.r2017.ls.cv.template.browser.marker.WithLogin;
import vse.p4it478.r2017.ls.cv.template.browser.marker.WithSearch;
import vse.p4it478.r2017.ls.cv.template.browser.marker.WithSpojeniSearch;
import vse.p4it478.r2017.ls.cv.template.browser.module.LoginModule;
import vse.p4it478.r2017.ls.cv.template.browser.module.RegisterModule;
import vse.p4it478.r2017.ls.cv.template.browser.module.SearchModule;
import vse.p4it478.r2017.ls.cv.template.browser.module.SpojeniModule;

import java.util.List;


public class CommonPage extends Page implements WithLogin, WithSearch, WithSpojeniSearch, Register {

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
	
	@FindBy(css = "a[title=\"Přihlaste se\"]")
	protected WebElement loginLink;
	
	@FindBy(css = "div[id=tools] > h2.second")
	protected WebElement timetablesLink;
	
	@FindBy(css = "#jr-rozcestnik > li:nth-child(1) > a")
	protected WebElement metroLink;
	
	@FindBy(css = "#jr-rozcestnik > li:nth-child(2) > a")
	protected WebElement busLink;

	@FindBy(css = "#menu > ul")
	private WebElement tabPanel;

	@FindBy(css = "#menu > ul > li > a")
	private List<WebElement> firstMenuItems;

	@FindBy(xpath = "//*[@id=\"menu\"]")
	private WebElement tabContent;

	public List<WebElement> getAllTabPanelButtons() {
		return tabPanel.findElements(By.cssSelector(" > li"));
	}

	public List<WebElement> getFirstMenuItems() {
		return firstMenuItems;
	}

	public String getTabContentTitle() {
		return tabContent.findElement(By.cssSelector(" > a")).getText().trim();
	}

	public String getFirstMenuItemTitle(int i) {
		return firstMenuItems.get(i).getText().trim();
	}

	public CommonPage goToFirstMenuItem(int i) {
		firstMenuItems.get(i).click();
		return browser.initPage(new CommonPage());
	}

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
	
	public CommonPage goToPrihlaseni() {
		linkRegistrace.click();
		return browser.initPage(new RegisterPage());
	}
	
	@Override
	public LoginCompletePage login(String username, String password) {
		return browser.initModule(new LoginModule(), loginLink).login(username, password);
	}
	
	public WebElement getLoginLink() {
		return loginLink;
	}
	
	public CommonPage goToLogin() {
		loginLink.click();
		return browser.initPage(new LoginCompletePage());
	}
	
	public LinePage goToMetro() {
		timetablesLink.click();
		String href = metroLink.getAttribute("href");
		browser.getDriver().get(href);
		return browser.initPage(new LinePage());
	}
	
	public LinePage goToBus() {
		timetablesLink.click();
		String href = busLink.getAttribute("href");
		browser.getDriver().get(href);
		return browser.initPage(new LinePage());
	}

	/*public void quickNavigateByValue(String value) {
		new Select(quickNavigationEl).selectByValue(value);
	}*/

	@Override
	public String getUri() {
		return null;
	}

}
