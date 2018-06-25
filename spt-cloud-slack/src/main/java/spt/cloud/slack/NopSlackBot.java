
package spt.cloud.slack;

/**
 * NOP {@link SlackBot}
 */
public class NopSlackBot implements SlackBot {
	
	/**
	 * {@inheritDoc}
	 * 
	 * @return {@code null}
	 */
	@Override
	public String postMessage(SlackMessage message) {
		
		return null;
	}
}
