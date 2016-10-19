import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.internal.Streams;
import org.openqa.selenium.support.ThreadGuard;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

public class RCTesting {

	final static String OPERATOR_AVAILABLE		= "79067076315";
	final static String OPERATOR_UNAVAILABLE	= "74824245255";

	final static String VISITOR_AVAILABLE		= "79607088020";
	final static String VISITOR_UNAVAILABLE		= "79094065104";


	@Test
	public void operatorUnavailable() {

		open("http://www.tsyopa.ru/ark");

		widgetEnable();

		$(By.id("rc-phone-form")).click();

		//ввод номера
		switchTo().frame("rc-connector-frame");
		$(By.id("rc-phone-input")).setValue(VISITOR_UNAVAILABLE);
		switchTo().defaultContent();

		$(By.id("rc-phone-button")).click();

	}

	//назначить проверки
	public void testAfterCallFeedbackForm() {
		$(By.id("rc-feedback"));								//class="rc-reset" style="position: fixed; top: 27px; right: 47%; bottom: auto; left: auto; display: block;">
			$(By.id("rc-feedback-close"));						//class="rc-can-press rc-reset"></div>
			$(By.id("rc-feedback-vote"));						//class="rc-reset" style="display: block;">
				$(By.id("rc-feedback-round"));					//class="rc-reset">
					$(By.id("rc-feedback-vote-question"));		//class="rc-reset">Оцените звонок оператора:</div>
					$(By.id("rc-feedback-vote-buttons"));		//class="rc-reset">
						$(By.id("rc-feedback-vote-yes"));		//class="rc-feedback-button rc-reset rc-feedback-liked" data-value="1">Да</div>
						$(By.id("rc-feedback-vote-no"));		//class="rc-feedback-button rc-reset rc-feedback-liked" data-value="0">Нет</div>
	}

	//проверка доступности виджета
	public void widgetEnable() {
//		<div id="rc-phone"
//		class="rc-reset rc-dark-back-color rc-time-editable rc-inactive rc-top-left"
//		style="bottom: auto; left: 663px; top: 103px; right: auto; position: fixed; display: block;">
	}

}
