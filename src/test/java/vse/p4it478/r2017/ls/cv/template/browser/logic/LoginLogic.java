package vse.p4it478.r2017.ls.cv.template.browser.logic;

import vse.p4it478.r2017.ls.cv.template.browser.Logic;
import vse.p4it478.r2017.ls.cv.template.browser.marker.WithLogin;
import vse.p4it478.r2017.ls.cv.template.browser.page.HomePage;
import vse.p4it478.r2017.ls.cv.template.browser.page.LoginCompletePage;

public class LoginLogic extends Logic {
	
	public LoginCompletePage login(String username, String password) {
		if (!(browser.getPage() instanceof WithLogin)) {
			browser.loadPage(new HomePage());
		}
		return browser.getPage(WithLogin.class).login(username, password);
	}

}
