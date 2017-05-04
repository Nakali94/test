package vse.p4it478.r2017.ls.cv.template.browser.page;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonPage {
	
	@Override
	public String getUri() {
		return "/";
	}

	@FindBy(css = "#menu > ul")
	private WebElement tabPanel;

	@FindBy(xpath = "//*[@id=\"menu\"]")
	private WebElement tabContent;

	public List<WebElement> getAllTabPanelButtons() {
		return tabPanel.findElements(By.tagName("li"));
	}
	public String getTabContentTitle() {
		return tabContent.findElement(By.tagName("a")).getText().trim();
	}


}
