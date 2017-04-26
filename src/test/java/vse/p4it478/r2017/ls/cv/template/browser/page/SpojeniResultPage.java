package vse.p4it478.r2017.ls.cv.template.browser.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpojeniResultPage extends CommonPage{

	@FindBy(css = "#frmResult > h1")
	protected WebElement h1;
	
	public String getH1(){
		return h1.getText().trim();
	}
}
