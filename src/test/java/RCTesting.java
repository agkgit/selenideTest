import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ThreadGuard;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
//import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;


public class RCTesting {

	@Test
	public void openSite () throws InterruptedException {

		open("http://www.redhelper.ru");

		$(By.id("rc-phone-form")).click();

		switchTo().frame("rc-connector-frame");
		$(By.id("rc-phone-input")).setValue("9999864875");

		//нужен id rc-connector-frame
		//switchTo().innerFrame("rc-connector-frame");
	}
}