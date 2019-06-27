
package spt.cloud.slack;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * {@link Test}: {@link SlackBot}
 */
@RunWith(SpringRunner.class)
// TODO
// @SpringBootTest(classes = SlackConfiguration.class)
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
	@Ignore
	@Test
	public void postMessage() {
		
		this.bot.postMessage("Test message");
	}
}
