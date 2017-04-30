package vse.p4it478.r2017.ls.cv.template.browser.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends CommonPage{

	@FindBy(css = "ul[class=NoticerError]")
	protected WebElement registerError;
	
	@FindBy(xpath = "//ul[@class='NoticerError']/li")
	protected WebElement errorText;
	
	public String getRegisterError(){
		return registerError.getText().trim();
	}
	
	public String getRegisterErrorText(){
		return errorText.getText().trim();
	}
}





