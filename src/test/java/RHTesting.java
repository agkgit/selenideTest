import com.codeborne.selenide.SelenideElement;
import com.rctests.OperatorBot;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.SystemClock;

import java.io.Console;

import static com.codeborne.selenide.Selenide.*;



public class RHTesting {

	@Test
	public void sendMessages() throws Exception {

//запуск бота--------------------------------------------------------------------------------------
		OperatorBot bot = new OperatorBot(	"krupenin",
											"qweasd",
											"xmpp.redhelper.ru",
											"xmpp.redhelper.ru", 5222);
		Thread thread = new Thread(bot);
		thread.start();
//-------------------------------------------------------------------------------------------------

		String[] messages = 	{"QWERTYUIOPASDFGHJKLZXCVBNM",
								"qwertyuiopasdfghjklzxcvbnm",
								"1234567890",
								"!@#$%^&*()-_=+{}[]|\" +<>,.?/",
								"ЁЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ",
								"йцукенгшщзхъфывапролджэячсмитьбю"	};

		open("http://www.vernee.ru/prod");
		sleep(1000);
		$(By.id("rh-badge")).click();

		switchTo().frame("rh-chatFrame");

		for (String message : messages) {

			$(By.id("chatTextarea")).setValue(message);
			$(By.id("chatSend")).click();

			String xpathVar =	".//div[@class='msgBlock fromOperator'][last()]" +
								"/div" +
								"/div[2]" +
								"/div[text()='" + message + "']";

			SelenideElement element = $(By.xpath(xpathVar));
			sleep(1000);
			System.out.print(" " + element.exists());
			if (!element.exists()) { throw new NoSuchElementException("не найден элемент "+ xpathVar); }
			sleep(1000);
		}
	}
}