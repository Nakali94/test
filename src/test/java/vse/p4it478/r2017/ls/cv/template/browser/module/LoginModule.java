package vse.p4it478.r2017.ls.cv.template.browser.module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import vse.p4it478.r2017.ls.cv.template.browser.Module;
import vse.p4it478.r2017.ls.cv.template.browser.page.LoginCompletePage;

public class LoginModule extends Module{
	
	@FindBy(id = "login")
	protected WebElement usernameFld;
	
	@FindBy(id = "password")
	protected WebElement passwordFld;
	
	@FindBy(css = "#f > div > p > input")
	protected WebElement loginBtn;
	
	public LoginCompletePage login(String username, String password) {
		usernameFld.clear();
		passwordFld.clear();
		usernameFld.sendKeys(username);
		passwordFld.sendKeys(password);
		loginBtn.click();
		return browser.initPage(new LoginCompletePage());
	}
	
	
	
		
	public WebElement findDynamicElement(By by, int timeOut) {
	    WebDriverWait wait = new WebDriverWait(browser.getDriver(), timeOut);
	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	    return element;
	}

}