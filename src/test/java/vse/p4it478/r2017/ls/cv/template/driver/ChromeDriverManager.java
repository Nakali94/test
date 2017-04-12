package vse.p4it478.r2017.ls.cv.template.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager {

	/**
     * System property that defines the location of the Chrome executable file.
     */
    public static final String BROWSER_BINARY = "webdriver.chrome.bin";
	
	public static ChromeDriver create() throws Exception {
		ChromeOptions options = new ChromeOptions();
		String browserBinary = System.getProperty(BROWSER_BINARY); 
		if (browserBinary != null) {
			options.setBinary(browserBinary);
		}
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;
	}

}
