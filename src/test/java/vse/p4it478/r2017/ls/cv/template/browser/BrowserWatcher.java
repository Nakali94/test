package vse.p4it478.r2017.ls.cv.template.browser;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.AssumptionViolatedException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logs info about test start and result.
 */
public class BrowserWatcher extends TestWatcher {

	private static final Path resultsPath = new File("target").toPath().resolve("surefire-reports");
	
	private static final Logger logger = LoggerFactory.getLogger(BrowserWatcher.class);
	
	private Browser browser;
	
	public void setBrowser(Browser browser) {
		this.browser = browser;
	}

	@Override
	protected void finished(Description description) {
		if (browser != null)
			browser.quit();
	}

	@Override
	protected void succeeded(Description description) {
		logger.info(getNameFromDescription(description) + " SUCCEEDED");
	}

	@Override
	protected void failed(Throwable e, Description description) {
		String name = getNameFromDescription(description);
		logger.info(name + " FAILED");
		
		if (browser != null && browser.getDriver() != null) {
			try {
				Files.createDirectories(resultsPath);
			} catch (Exception e2) {
				logger.error("Error while creating results directory in " + resultsPath, e2);
			}
			
			Path screenshotPath = resultsPath.resolve(name + "-screenshot-failed.png"); 
			try {
				Files.write(screenshotPath, ((TakesScreenshot) browser.getDriver()).getScreenshotAs(OutputType.BYTES));
			} catch (Exception e2) {
				logger.error("Error while saving failed screenshot to " + screenshotPath, e2);
			}
			Path sourceCodePath = resultsPath.resolve(name + "-source-failed.html"); 
			try {
				Files.write(sourceCodePath, browser.getDriver().getPageSource().getBytes());
			} catch (Exception e2) {
				logger.error("Error while saving failed source code to " + sourceCodePath, e2);
			}
		}
	}

	@Override
	protected void skipped(AssumptionViolatedException e, Description description) {
		logger.info(getNameFromDescription(description) + " SKIPPED");
	}

	@Override
	protected void starting(Description description) {
		logger.info(getNameFromDescription(description) + " STARTING");
	}
	
	private String getNameFromDescription(Description description) {
		return description.getClassName() + "." + description.getMethodName();
	}

}
