package vse.p4it478.r2017.ls.cv.template.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import vse.p4it478.r2017.ls.cv.template.browser.Browser;
import vse.p4it478.r2017.ls.cv.template.browser.BrowserException;

public class DriverManager {

	/**
     * System property that defines the location of the Chrome executable file.
     */
    public static final String CHROME_BROWSER_BINARY = "webdriver.chrome.bin";

	public static PhantomJSDriver createPhantomJSDriver(Browser browser) {
		String executablePath = browser.getProperty(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY);
		if (executablePath == null)
			throw new BrowserException(
					"Property " + PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY + " is required.");
		System.setProperty(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, executablePath);
		DesiredCapabilities caps = DesiredCapabilities.phantomjs();
		caps.setJavascriptEnabled(true);
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,
				new String[] { "--web-security=no", "--ignore-ssl-errors=yes", "--ssl-protocol=tlsv1" });
		PhantomJSDriver driver = new PhantomJSDriver(caps);
		driver.manage().window().setSize(new Dimension(1280, 800));
		return driver;
	}
	
	public static ChromeDriver createChromeDriver() throws Exception {
		String executablePath = System.getProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY);
		if (executablePath == null)
			throw new BrowserException("Property " + ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY + " is required.");
		
		ChromeOptions options = new ChromeOptions();
		String browserBinary = System.getProperty(CHROME_BROWSER_BINARY); 
		if (browserBinary != null) {
			options.setBinary(browserBinary);
		}
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver createChromeDriver(Browser browser) {
		String executablePath = browser.getProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY);
		if (executablePath == null)
			throw new BrowserException("Property " + ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY + " is required.");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, executablePath);
		
		ChromeOptions options = new ChromeOptions();
		String browserBinary = browser.getProperty(CHROME_BROWSER_BINARY); 
		if (browserBinary != null) {
			options.setBinary(browserBinary);
		}
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver createRemoteWebDriver(Browser browser) throws MalformedURLException {
		String hubUrl = browser.getProperty("hubUrl");
		if (hubUrl == null)
			throw new BrowserException("Property hubUrl is required.");
		DesiredCapabilities caps = new DesiredCapabilities();
		browser.getProperties().entrySet().stream()
				.filter(entry -> entry.getKey() != null && entry.getKey().toString().startsWith("caps."))
				.forEach(entry -> {
					caps.setCapability(entry.getKey().toString().substring("caps.".length()), entry.getValue());
				});
		return new RemoteWebDriver(new URL(hubUrl), caps);
	}


}
