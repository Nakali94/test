package vse.p4it478.r2017.ls.cv.template.browser.module;

import vse.p4it478.r2017.ls.cv.template.browser.Module;
import vse.p4it478.r2017.ls.cv.template.browser.page.LinePage;

public class LineModule extends Module{
	

	public LinePage getLinePage() {
		return browser.initPage(new LinePage());
	}

}