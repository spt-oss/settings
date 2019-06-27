
package spt.cloud;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.StringUtils;

import lombok.Data;

/**
 * Slack properties
 */
@ConfigurationProperties("project.slack")
@Data
public class SlackProperties {
	
	/**
	 * Token
	 */
	private String token;
	
	/**
	 * Channel
	 */
	private String channel;
	
	/**
	 * Is mock?
	 * 
	 * @return {@code true} if mock
	 */
	public boolean isMock() {
		
		return !StringUtils.hasText(this.token) || !StringUtils.hasText(this.channel);
	}
}
