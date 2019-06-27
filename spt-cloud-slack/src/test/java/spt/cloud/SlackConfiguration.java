
package spt.cloud;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import spt.cloud.slack.SlackBot;
import spt.cloud.slack.SlackBotImpl;

/**
 * {@link Configuration}: Slack
 */
@Configuration
@EnableConfigurationProperties(SlackProperties.class)
@RequiredArgsConstructor
public class SlackConfiguration {
	
	/**
	 * {@link SlackProperties}
	 */
	@NonNull
	private final SlackProperties properties;
	
	/**
	 * {@link Bean}: {@link SlackBot}
	 * 
	 * @return {@link SlackBot}
	 */
	@Bean(initMethod = "connect", destroyMethod = "disconnect")
	public SlackBot slackBot() {
		
		if (this.properties.isMock()) {
			
			return new SlackBotMock();
		}
		
		return new SlackBotImpl(
		/* @formatter:off */
			this.properties.getToken(),
			this.properties.getChannel()
			/* @formatter:on */
		);
	}
	
	/**
	 * {@link SlackBot} mock
	 */
	protected static class SlackBotMock implements SlackBot {
		
		@Override
		public String postMessage(String message) {
			
			return "timestamp";
		}
		
		/**
		 * Connect
		 */
		public void connect() {
			
			/* NOP */
		}
		
		/**
		 * Disconnect
		 */
		public void disconnect() {
			
			/* NOP */
		}
	}
}
