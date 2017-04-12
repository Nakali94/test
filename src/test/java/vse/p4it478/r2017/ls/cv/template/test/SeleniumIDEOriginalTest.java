package vse.p4it478.r2017.ls.cv.template.test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import vse.p4it478.r2017.ls.cv.template.driver.ChromeDriverManager;

@Ignore("It does not found option in selectbox and holds for 30s then.")
public class SeleniumIDEOriginalTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	driver = ChromeDriverManager.create();
    baseUrl = "http://kit.vse.cz/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSeleniumIDEOriginalTest() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Profil katedry")).click();
    assertTrue(driver.getTitle().matches("^[\\s\\S]*Profil katedry[\\s\\S]*$"));
    driver.findElement(By.id("s")).clear();
    driver.findElement(By.id("s")).sendKeys("4it478");
    driver.findElement(By.cssSelector("input.submit")).click();
    driver.findElement(By.cssSelector("a[title=\"4KS – Řízení kvality softwaru (VS)\"]")).click();
    assertTrue(driver.getTitle().matches("^[\\s\\S]*4KS – Řízení kvality softwaru \\(VS\\)[\\s\\S]*$"));
    String url = driver.getCurrentUrl();
    new Select(driver.findElement(By.cssSelector("select.text"))).selectByVisibleText("regexp:->\\sInformační zdroje");
    assertThat(url, is(not(driver.getTitle())));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
