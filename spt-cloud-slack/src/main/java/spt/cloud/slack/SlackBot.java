
package spt.cloud.slack;

/**
 * Slack bot
 */
public interface SlackBot {
	
	/**
	 * Post message
	 * 
	 * @param message message
	 * @return timestamp
	 */
	String postMessage(String message);
}
