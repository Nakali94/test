package vse.p4it478.r2017.ls.cv.template.browser.logic;

import vse.p4it478.r2017.ls.cv.template.browser.Logic;
import vse.p4it478.r2017.ls.cv.template.browser.marker.WithSearch;
import vse.p4it478.r2017.ls.cv.template.browser.page.HomePage;
import vse.p4it478.r2017.ls.cv.template.browser.page.SearchResultPage;

public class SearchLogic extends Logic {

	public SearchResultPage search(String text) {
		if (!(browser.getPage() instanceof WithSearch)) {
			browser.loadPage(new HomePage());
		}
		return browser.getPage(WithSearch.class).search(text);
	}

}
