package vse.p4it478.r2017.ls.cv.template.browser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Wraps {@link WebDriver}, configuration and provides numerous helper methods
 * for working with page like objects.
 */
public class Browser {

	public static final String ENCODING = "UTF-8";

	protected WebDriver driver;

	protected Page page;

	protected Properties properties = new Properties();

	/**
	 * Redirects to {@link Page} and initializes it.
	 * 
	 * @param page
	 * @return
	 */
	public <T extends Page> T loadPage(T page) {
		page.load(this);
		return page;
	}

	/**
	 * Redirects to {@link Page} and initializes it in specific
	 * {@link SearchContext}.
	 * 
	 * @param page
	 * @param context
	 * @return
	 */
	public <T extends Page> T loadPage(T page, SearchContext context) {
		page.load(this, context);
		return page;
	}

	/**
	 * Initializes {@link Page}.
	 * 
	 * @param page
	 * @return
	 */
	public <T extends Page> T initPage(T page) {
		page.init(this);
		return page;
	}

	/**
	 * Initializes {@link Page} in specific {@link SearchContext}.
	 * 
	 * @param page
	 * @param context
	 * @return
	 */
	public <T extends Page> T initPage(T page, SearchContext context) {
		page.init(this, context);
		return page;
	}

	/**
	 * Initializes {@link Module}.
	 * 
	 * @param module
	 * @return
	 */
	public <T extends Module> T initModule(T module) {
		module.init(this);
		return module;
	}

	/**
	 * Initializes {@link Module} in specific {@link SearchContext}.
	 * 
	 * @param module
	 * @param context
	 * @return
	 */
	public <T extends Module> T initModule(T module, SearchContext context) {
		module.init(this, context);
		return module;
	}

	/**
	 * Initializes {@link Logic}.
	 * 
	 * @param logic
	 * @return
	 */
	public <T extends Logic> T initLogic(T logic) {
		logic.init(this);
		return logic;
	}

	/**
	 * Initializes {@link Logic} in specific {@link SearchContext}.
	 * 
	 * @param module
	 * @param context
	 * @return
	 */
	public <T extends Logic> T initLogic(T logic, SearchContext context) {
		logic.init(this, context);
		return logic;
	}

	/**
	 * Quits underlying {@link WebDriver}.
	 */
	public void quit() {
		if (driver != null)
			driver.quit();
	}

	public Browser addProperties(Properties properties) {
		this.properties.putAll(properties);
		return this;
	}

	public Browser addProperties(File file, boolean required) {
		if (!file.canRead()) {
			if (required)
				throw new BrowserException("Properties file is not readable " + file);
			return this;
		}
		Properties properties = new Properties();
		try {
			properties.load(new InputStreamReader(new FileInputStream(file), ENCODING));
		} catch (IOException e) {
			throw new BrowserException("Error while reading properties file " + file);
		}
		return addProperties(properties);
	}

	public Browser addProperties(String resourceName, boolean required) {
		InputStream is = Browser.class.getClassLoader().getResourceAsStream(resourceName);
		if (is == null) {
			if (required)
				throw new BrowserException("Properties resource does not exists " + resourceName);
			return this;
		}
		Properties properties = new Properties();
		try {
			properties.load(new InputStreamReader(is, ENCODING));
		} catch (IOException e) {
			throw new BrowserException("Error while reading properties resource " + resourceName);
		}
		return addProperties(properties);
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public String getProperty(String key) {
		return getProperty(key, null);
	}

	public String getProperty(String key, String def) {
		String value = properties.getProperty(key);
		return value == null ? def : value;
	}

	public void setProperty(String key, String value) {
		properties.setProperty(key, value);
	}

	public WebDriver getDriver() {
		if (driver == null) {
			driver = new FirefoxDriver();
		}
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public Page getPage() {
		return page;
	}

	@SuppressWarnings("unchecked")
	public <T> T getPage(Class<T> pageClass) {
		return (T) page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
