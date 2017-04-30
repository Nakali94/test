package vse.p4it478.r2017.ls.cv.template.browser.module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import vse.p4it478.r2017.ls.cv.template.browser.Module;
import vse.p4it478.r2017.ls.cv.template.browser.page.RegisterPage;

public class RegisterModule extends Module{
	
	@FindBy(css = "input[id=login]")
	protected WebElement nicknameFld;
	
	@FindBy(css = "input[id=email]")
	protected WebElement emailFld;
	
	@FindBy(css = "input[id=phone]")
	protected WebElement phoneFld;
	
	@FindBy(css = "input[id=password]")
	protected WebElement passwordFld;
	
	@FindBy(css = "input[id=pwwsd-a]")
	protected WebElement pwwsdFld;
	
	@FindBy(css = "input[name=interest[newsletter]")
	protected WebElement newsletter;
	
	@FindBy(css = "input[name=channel[email]")
	protected WebElement kanalEmail;
	
	@FindBy(css = "input[name=bbz[sms]")
	protected WebElement kanalSms;
	
	@FindBy(css = "input[id=conditions")
	protected WebElement obchPodm;
	
	@FindBy(css = "input[name=__event_onclick[btn_submit]")
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
