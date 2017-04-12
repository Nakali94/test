package vse.p4it478.r2017.ls.cv.template.browser;

import org.openqa.selenium.SearchContext;

/**
 * Abstract parent for classes which presents a page of UI.
 */
abstract public class Page extends BrowserContext {

	protected boolean loading = false;

	/**
	 * URI of this page. It is appended to base URL to create complete URL. It
	 * should start with slash.
	 * 
	 * @return
	 */
	abstract public String getUri();

	/**
	 * Redirects to this page using same {@link Browser} and
	 * {@link SearchContext}.
	 */
	public void reload() {
		loading = true;
		try {
			reinit();
		} finally {
			loading = false;
		}
	}

	/**
	 * Redirects to this page using given {@link Browser}.
	 * 
	 * @param browser
	 */
	public void load(Browser browser) {
		loading = true;
		try {
			init(browser);
		} finally {
			loading = false;
		}
	}

	/**
	 * Redirects to this page using given {@link Browser} and
	 * {@link SearchContext}.
	 * 
	 * @param browser
	 * @param context
	 */
	public void load(Browser browser, SearchContext context) {
		loading = true;
		try {
			init(browser, context);
		} finally {
			loading = false;
		}
	}

	/**
	 * Gets complete URL for this page.
	 * 
	 * @return
	 */
	public String getUrl() {
		return getBaseUrl() + getUri();
	}

	/**
	 * Gets base URL for this page. Usually domain. It should end without slash.
	 * 
	 * @return
	 */
	public String getBaseUrl() {
		return browser.getProperty("baseUrl");
	}

	@Override
	protected void beforeInitElements() {
		super.beforeInitElements();
		if (loading)
			goTo();
	}

	@Override
	protected void afterInitElements() {
		browser.setPage(this);
		super.afterInitElements();
	}

	protected void goTo() {
		browser.getDriver().get(getUrl());
	}

}
