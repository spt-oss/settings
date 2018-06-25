
package spt.cloud.slack.util;

import lombok.NonNull;
import spt.cloud.slack.SlackMessage;

/**
 * {@link SlackMessage} builder
 */
public class SlackMessageBuilder {
	
	/**
	 * Delegate
	 */
	private StringBuilder text = new StringBuilder();
	
	/**
	 * Append
	 * 
	 * @param value value
	 * @return {@link SlackMessageBuilder}
	 */
	public SlackMessageBuilder and(Object value) {
		
		this.text.append(String.valueOf(value));
		
		return this;
	}
	
	/**
	 * Append
	 * 
	 * @param builder {@link SlackMessageBuilder}
	 * @return {@link SlackMessageBuilder}
	 */
	public SlackMessageBuilder append(@NonNull SlackMessageBuilder builder) {
		
		this.and(builder.toString());
		
		return this;
	}
	
	/**
	 * Mention "@channel"
	 * 
	 * @return {@link SlackMessageBuilder}
	 */
	public SlackMessageBuilder mentionChannel() {
		
		this.and("<!channel>");
		
		return this;
	}
	
	/**
	 * Blockquote
	 * 
	 * @return {@link SlackMessageBuilder}
	 */
	public SlackMessageBuilder blockquote() {
		
		this.and("> ");
		
		return this;
	}
	
	/**
	 * Bold
	 * 
	 * @return {@link SlackMessageBuilder}
	 */
	public SlackMessageBuilder bold() {
		
		this.and("*");
		
		return this;
	}
	
	/**
	 * Italic
	 * 
	 * @return {@link SlackMessageBuilder}
	 */
	public SlackMessageBuilder italic() {
		
		this.and("_");
		
		return this;
	}
	
	/**
	 * Line feed
	 * 
	 * @return {@link SlackMessageBuilder}
	 */
	public SlackMessageBuilder linefeed() {
		
		this.and("\n");
		
		return this;
	}
	
	/**
	 * Minus
	 * 
	 * @return {@link SlackMessageBuilder}
	 */
	public SlackMessageBuilder minus() {
		
		this.and("-");
		
		return this;
	}
	
	/**
	 * NOP
	 * 
	 * @return {@link SlackMessageBuilder}
	 */
	public SlackMessageBuilder nop() {
		
		this.and("");
		
		return this;
	}
	
	/**
	 * Plus
	 * 
	 * @return {@link SlackMessageBuilder}
	 */
	public SlackMessageBuilder plus() {
		
		this.and("+");
		
		return this;
	}
	
	/**
	 * Quote
	 * 
	 * @return {@link SlackMessageBuilder}
	 */
	public SlackMessageBuilder quote() {
		
		this.and("`");
		
		return this;
	}
	
	/**
	 * Space
	 * 
	 * @return {@link SlackMessageBuilder}
	 */
	public SlackMessageBuilder space() {
		
		this.and(" ");
		
		return this;
	}
	
	/**
	 * Build
	 * 
	 * @return {@link SlackMessage}
	 */
	public SlackMessage build() {
		
		return () -> this.text.toString();
	}
}
