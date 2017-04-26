package vse.p4it478.r2017.ls.cv.template.browser.logic;

import vse.p4it478.r2017.ls.cv.template.browser.Logic;
import vse.p4it478.r2017.ls.cv.template.browser.marker.WithSpojeniSearch;
import vse.p4it478.r2017.ls.cv.template.browser.page.HomePage;
import vse.p4it478.r2017.ls.cv.template.browser.page.SpojeniResultPage;

public class SpojeniLogic extends Logic{

	public SpojeniResultPage search(String odkud, String kam, String cas) {
		if (!(browser.getPage() instanceof WithSpojeniSearch)) {
			browser.loadPage(new HomePage());
		}
		return browser.getPage(WithSpojeniSearch.class).search(odkud, kam, cas);
	}
}
