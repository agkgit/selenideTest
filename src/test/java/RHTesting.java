import com.codeborne.selenide.SelenideElement;
import com.rctests.OperatorBot;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.*;

public class RHTesting {

	@Step("sendMessages")
	@Test
	public void sendMessages() throws Exception {

		startEchoBot();

		String[] messages = 	{"QWERTYUIOPASDFGHJKLZXCVBNM",			"qwertyuiopasdfghjklzxcvbnm",
								"1234567890",							"!@#$%^&*()-_=+{}[]|\" +<>,.?/",
								"ЁЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ",	"йцукенгшщзхъфывапролджэячсмитьбю"	};

		open("http://www.vernee.ru/prod");	sleep(1000);
		$(By.id("rh-badge")).click();

		switchTo().frame("rh-chatFrame");

		for (String message : messages) {

			$(By.id("chatTextarea")).setValue(message);
			$(By.id("chatSend")).click();

			String xpathOfLastMessageFromOperator =	".//div[@class='msgBlock fromOperator'][last()]" +
													"/div/div[2]/div[text()='" + message + "']";

			SelenideElement lastMessageFromOperator = $(By.xpath(xpathOfLastMessageFromOperator));	sleep(1000);

			if (!lastMessageFromOperator.exists()) {
				throw new NoSuchElementException("не найден элемент "+ xpathOfLastMessageFromOperator);
			}
		}
	}

	public void startEchoBot() {
		OperatorBot bot = new OperatorBot	("krupenin",				//login
											"qweasd",				//password
											"xmpp.redhelper.ru",	//domain
											"xmpp.redhelper.ru",	//server
											5222					//port
											);
		Thread thread = new Thread(bot);
		thread.start();
	}

}