package vse.p4it478.r2017.ls.cv.template.browser.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginCompletePage extends CommonPage {

	@FindBy(css = "#pole > h1")
	protected WebElement profile;
	
	public String getProfile(){
		return profile.getText().trim();
	}

}
