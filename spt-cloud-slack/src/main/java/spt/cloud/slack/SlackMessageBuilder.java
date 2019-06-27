
package spt.cloud.slack;

import lombok.NonNull;

/**
 * Slack message builder
 */
public class SlackMessageBuilder {
	
	/**
	 * Text
	 */
	private StringBuilder text = new StringBuilder();
	
	/**
	 * Append
	 * 
	 * @param value value
	 * @return {@link SlackMessageBuilder}
	 */
	public SlackMessageBuilder append(Object value) {
		
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
		
		this.append(builder.toString());
		
		return this;
	}
	
	/**
	 * "@channel"
	 * 
	 * @return {@link SlackMessageBuilder}
	 */
	public SlackMessageBuilder atChannel() {
		
		this.append("<!channel>");
		
		return this;
	}
	
	/**
	 * "@here"
	 * 
	 * @return {@link SlackMessageBuilder}
	 */
	public SlackMessageBuilder atHere() {
		
		this.append("<!here>");
		
		return this;
	}
	
	/**
	 * Blockquote
	 * 
	 * @return {@link SlackMessageBuilder}
	 */
	public SlackMessageBuilder blockquote() {
		
		this.append(">");
		
		return this;
	}
	
	/**
	 * Bold
	 * 
	 * @return {@link SlackMessageBuilder}
	 */
	public SlackMessageBuilder bold() {
		
		this.append("*");
		
		return this;
	}
	
	/**
	 * Italic
	 * 
	 * @return {@link SlackMessageBuilder}
	 */
	public SlackMessageBuilder italic() {
		
		this.append("_");
		
		return this;
	}
	
	/**
	 * Line feed
	 * 
	 * @return {@link SlackMessageBuilder}
	 */
	public SlackMessageBuilder linefeed() {
		
		this.append("\n");
		
		return this;
	}
	
	/**
	 * Minus
	 * 
	 * @return {@link SlackMessageBuilder}
	 */
	public SlackMessageBuilder minus() {
		
		this.append("-");
		
		return this;
	}
	
	/**
	 * NOP
	 * 
	 * @return {@link SlackMessageBuilder}
	 */
	public SlackMessageBuilder nop() {
		
		this.append("");
		
		return this;
	}
	
	/**
	 * Plus
	 * 
	 * @return {@link SlackMessageBuilder}
	 */
	public SlackMessageBuilder plus() {
		
		this.append("+");
		
		return this;
	}
	
	/**
	 * Quote
	 * 
	 * @return {@link SlackMessageBuilder}
	 */
	public SlackMessageBuilder quote() {
		
		this.append("`");
		
		return this;
	}
	
	/**
	 * Space
	 * 
	 * @return {@link SlackMessageBuilder}
	 */
	public SlackMessageBuilder space() {
		
		this.append(" ");
		
		return this;
	}
	
	/**
	 * Build
	 * 
	 * @return message
	 */
	public String build() {
		
		return this.text.toString();
	}
	
	@Override
	public String toString() {
		
		return this.build();
	}
}
