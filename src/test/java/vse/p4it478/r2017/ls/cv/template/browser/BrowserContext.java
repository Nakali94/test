package vse.p4it478.r2017.ls.cv.template.browser;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

/**
 * Abstract parent for {@link Page}, {@link Module} and {@link Logic}.
 */
abstract public class BrowserContext {

	protected Browser browser;

	protected SearchContext context;

	/**
	 * Initializes browser context.
	 * 
	 * @param browser
	 */
	public void init(Browser browser) {
		init(browser, browser.getDriver());
	}

	/**
	 * Initializes browser context in specific search context.
	 * 
	 * @param browser
	 * @param context
	 */
	public void init(Browser browser, SearchContext context) {
		this.browser = browser;
		this.context = context;
		reinit();
	}

	/**
	 * Reinitializes browser context.
	 */
	public void reinit() {
		beforeInitElements();
		PageFactory.initElements(new DefaultElementLocatorFactory(context), this);
		afterInitElements();
	}

	/**
	 * Is called before elements are initialized but after {@link Browser} and
	 * {@link SearchContext} are set.
	 */
	protected void beforeInitElements() {
		// do whatever you need before initialization
	}

	/**
	 * Is called after elements are initialized.
	 */
	protected void afterInitElements() {
		// do whatever you need after initialization
	}

}
