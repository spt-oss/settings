
package spt.cloud.slack.client;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.XLoggingInterceptorCustomizer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import spt.cloud.TestApplication;
import spt.cloud.TestProperties;
import spt.cloud.TestProperties.SlackSettings;
import spt.cloud.slack.NopSlackBot;
import spt.cloud.slack.SlackBot;
import spt.cloud.slack.SlackBotImpl;
import spt.cloud.slack.SlackMessage;

/**
 * {@link Test}: {@link SlackBotImpl}
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
@ActiveProfiles("test")
public class SlackBotImplTests {
	
	/**
	 * {@link TestProperties}
	 */
	@Autowired
	private TestProperties properties;
	
	/**
	 * {@link SlackBot}
	 */
	private SlackBot bot;
	
	/**
	 * {@link Before}
	 */
	@Before
	public void before() {
		
		SlackSettings settings = this.properties.getSlack();
		
		this.bot = new SlackBotImpl(
		/* @formatter:off */
			new RestTemplateBuilder(new XLoggingInterceptorCustomizer()),
			settings.getToken(),
			settings.getChannel()
			/* @formatter:on */
		);
		
		if (!StringUtils.hasText(settings.getToken())) {
			
			this.bot = new NopSlackBot();
		}
	}
	
	/**
	 * {@link SlackBot#postMessage(SlackMessage)}
	 */
	@Test
	public void postMessage() {
		
		this.bot.postMessage(() -> "Test message");
	}
}
