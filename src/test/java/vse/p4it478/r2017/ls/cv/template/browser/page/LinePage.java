package vse.p4it478.r2017.ls.cv.template.browser.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinePage extends CommonPage {

	@FindBy(css = "div[id=pole] > h1")
	protected WebElement title;
	
	@FindBy(css = "div[id=pole] > div:nth-child(2) > h2")
	protected WebElement firstLine;
		
	public String getTitle(){
		return title.getText().trim();
	}
	
	public String getFirstLine(){
		return firstLine.getText().trim();
	}
}
