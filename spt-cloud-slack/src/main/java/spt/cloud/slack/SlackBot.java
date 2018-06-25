
package spt.cloud.slack;

import org.springframework.web.client.RestClientException;

/**
 * Slack bot
 */
public interface SlackBot {
	
	/**
	 * Post message
	 * 
	 * @param message {@link SlackMessage}
	 * @return timestamp
	 * @throws RestClientException if failed to post
	 */
	String postMessage(SlackMessage message) throws RestClientException;
}
