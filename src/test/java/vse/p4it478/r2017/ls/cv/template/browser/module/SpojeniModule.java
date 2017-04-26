package vse.p4it478.r2017.ls.cv.template.browser.module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import vse.p4it478.r2017.ls.cv.template.browser.Module;
import vse.p4it478.r2017.ls.cv.template.browser.page.SpojeniResultPage;

public class SpojeniModule extends Module{
	
	@FindBy(css = "#from")
	protected WebElement vyhledavaniSpojeniOdkud;
	
	@FindBy(css = "#to")
	protected WebElement vyhledavaniSpojeniKam;
	
	@FindBy(css = "#date")
	protected WebElement vyhledavaniSpojeniDatum;
	
	@FindBy(css = "#time")
	protected WebElement vyhledavaniSpojeniCas;
	
	@FindBy(css = "#change-from-to")
	protected WebElement vyhledavaniSpojeniProhodit;
	
	@FindBy(css = "#route > p.submit-line > input")
	protected WebElement vyhledavaniSpojeniSubmit;
	
	public SpojeniResultPage search(String odkud, String kam, String cas) {
		vyhledavaniSpojeniOdkud.clear();
		vyhledavaniSpojeniKam.clear();
		vyhledavaniSpojeniCas.clear();
		vyhledavaniSpojeniOdkud.sendKeys(odkud);
		vyhledavaniSpojeniKam.sendKeys(kam);
		vyhledavaniSpojeniCas.sendKeys(cas);
		vyhledavaniSpojeniSubmit.click();
		return browser.initPage(new SpojeniResultPage());
	}
	
	public String getVyhledavaniSpojeniDatum(){
		return vyhledavaniSpojeniDatum.getAttribute("value");
	}
	
	public void clickVyhledavaniSpojeniProhodit(String odkud, String kam){
		vyhledavaniSpojeniOdkud.clear();
		vyhledavaniSpojeniKam.clear();
		vyhledavaniSpojeniCas.clear();
		vyhledavaniSpojeniOdkud.sendKeys(odkud);
		vyhledavaniSpojeniKam.sendKeys(kam);
		vyhledavaniSpojeniProhodit.click();
	}
	
	public String getVyhledavaniSpojeniOdkud(){
		return vyhledavaniSpojeniOdkud.getText().trim();
	}
	
	public String getVyhledavaniSpojeniKam(){
		return vyhledavaniSpojeniKam.getText().trim();
	}
	
	public String getNaseptavacResult(String text){
		vyhledavaniSpojeniOdkud.sendKeys(text);
		return findDynamicElement(By.cssSelector(".ac_item"),5000).getText().trim();
	}
	
	public WebElement findDynamicElement(By by, int timeOut) {
	    WebDriverWait wait = new WebDriverWait(browser.getDriver(), timeOut);
	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	    return element;
	}

}
