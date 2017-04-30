package vse.p4it478.r2017.ls.cv.template.browser.module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import vse.p4it478.r2017.ls.cv.template.browser.Module;
import vse.p4it478.r2017.ls.cv.template.browser.page.RegisterPage;

public class RegisterModule extends Module{
	
	@FindBy(id = "login")
	protected WebElement nicknameFld;
	
	@FindBy(id = "email")
	protected WebElement emailFld;
	
	@FindBy(id = "phone")
	protected WebElement phoneFld;
	
	@FindBy(id = "password")
	protected WebElement passwordFld;
	
	@FindBy(id = "pwwsd-a")
	protected WebElement pwwsdFld;
	
	@FindBy(css = "#form > div > fieldset:nth-child(5) > p:nth-child(3) > label > input[type=\"checkbox\"]")
	protected WebElement newsletter;
	
	@FindBy(css = "#form > div > fieldset:nth-child(6) > p > label > input[type=\"checkbox\"]")
	protected WebElement kanalEmail;
	
	@FindBy(css = "#form > div > fieldset:nth-child(7) > p > label > input[type=\"checkbox\"]")
	protected WebElement kanalSms;
	
	@FindBy(id = "conditions")
	protected WebElement obchPodm;
	
	@FindBy(css = "#form > div > p > input")
	protected WebElement btnRegistrovat;
	
	public RegisterPage register(String nick, String email, String tel, String heslo, String hesloznov) {
		nicknameFld.clear();
		emailFld.clear();
		phoneFld.clear();
		passwordFld.clear();
		pwwsdFld.clear();
		nicknameFld.sendKeys(nick);
		emailFld.sendKeys(email);
		phoneFld.sendKeys(tel);
		passwordFld.sendKeys(heslo);
		pwwsdFld.sendKeys(hesloznov);
		btnRegistrovat.click();
		return browser.initPage(new RegisterPage());
	}
	
	
	
		
	public WebElement findDynamicElement(By by, int timeOut) {
	    WebDriverWait wait = new WebDriverWait(browser.getDriver(), timeOut);
	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	    return element;
	}

}
