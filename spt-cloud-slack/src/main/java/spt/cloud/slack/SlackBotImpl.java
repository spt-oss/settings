
package spt.cloud.slack;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * {@link SlackBot} implementation
 */
public class SlackBotImpl implements SlackBot {
	
	/**
	 * {@link RestTemplate}
	 */
	private final RestTemplate restTemplate;
	
	/**
	 * Token
	 */
	private final String token;
	
	/**
	 * Channel
	 */
	private final String channel;
	
	/**
	 * As user
	 */
	@Setter
	@Accessors(chain = true)
	private boolean asUser = true;
	
	/**
	 * Constructor
	 * 
	 * @param builder {@link RestTemplateBuilder}
	 * @param token {@link #token}
	 * @param channel {@link #channel}
	 */
	public SlackBotImpl(@NonNull RestTemplateBuilder builder, String token, String channel) {
		
		this.restTemplate = builder.rootUri("https://slack.com/api").build();
		this.token = token;
		this.channel = channel;
	}
	
	@Override
	public String postMessage(@NonNull SlackMessage message) throws RestClientException {
		
		Map<String, Object> params = new LinkedHashMap<>();
		params.put("channel", this.channel);
		params.put("text", message.getText());
		params.put("as_user", this.asUser);
		
		SlackPostMessageResponse response = this.restTemplate.postForObject(
		/* @formatter:off */
			"/chat.postMessage",
			this.getHttpEntity(params),
			SlackPostMessageResponse.class
			/* @formatter:on */
		);
		
		return response.getTimestamp();
	}
	
	/**
	 * Get {@link HttpEntity}
	 * 
	 * @param params params
	 * @return {@link HttpEntity}
	 */
	protected HttpEntity<?> getHttpEntity(Map<String, Object> params) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + this.token);
		
		return new HttpEntity<>(params, headers);
	}
	
	/**
	 * Slack response
	 */
	@Data
	protected static class SlackResponse {
		
		/**
		 * OK
		 */
		@JsonProperty("ok")
		private boolean success;
	}
	
	/**
	 * {@link SlackResponse}: {@link SlackBot#postMessage(SlackMessage)}
	 */
	@Data
	@EqualsAndHashCode(callSuper = false)
	protected static class SlackPostMessageResponse extends SlackResponse {
		
		/**
		 * Timestamp
		 */
		@JsonProperty("ts")
		private String timestamp;
	}
}
