package vse.p4it478.r2017.ls.cv.template.browser;

import org.openqa.selenium.WebDriverException;

/**
 * Indicates exception thrown from browser.
 */
public class BrowserException extends WebDriverException {

	private static final long serialVersionUID = 4838988795254333353L;

	public BrowserException() {
		super();
	}

	public BrowserException(String message, Throwable cause) {
		super(message, cause);
	}

	public BrowserException(String message) {
		super(message);
	}

	public BrowserException(Throwable cause) {
		super(cause);
	}

}
