package vse.p4it478.r2017.ls.cv.template.browser.logic;

import vse.p4it478.r2017.ls.cv.template.browser.Logic;
import vse.p4it478.r2017.ls.cv.template.browser.marker.Register;
import vse.p4it478.r2017.ls.cv.template.browser.page.HomePage;
import vse.p4it478.r2017.ls.cv.template.browser.page.RegisterPage;


public class RegisterLogic extends Logic{

	public RegisterPage register(String nick, String email, String tel, String heslo, String hesloznov) {
		if (!(browser.getPage() instanceof Register)) {
			browser.loadPage(new HomePage());
		}
		return browser.getPage(Register.class).register(nick, email, tel, heslo, hesloznov);
	}
}


