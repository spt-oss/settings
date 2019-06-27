
package spt.cloud.slack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import spt.cloud.SlackConfiguration;

/**
 * {@link Test}: {@link SlackBot}
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SlackConfiguration.class)
@ActiveProfiles("test")
public class SlackBotTests {
	
	/**
	 * {@link SlackBot}
	 */
	@Autowired
	private SlackBot bot;
	
	/**
	 * {@link SlackBot#postMessage(String)}
	 */
	@Test
	public void postMessage() {
		
		this.bot.postMessage("Test message");
	}
}
