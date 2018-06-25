
package spt.cloud;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * Test properties
 */
@ConfigurationProperties("test")
@Data
public class TestProperties {
	
	/**
	 * {@link SlackSettings}
	 */
	private SlackSettings slack = new SlackSettings();
	
	/**
	 * App
	 */
	@Data
	public static class SlackSettings {
		
		/**
		 * Token
		 */
		private String token;
		
		/**
		 * Channel
		 */
		private String channel;
	}
}
