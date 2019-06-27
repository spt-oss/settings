/*
 * Copyright 2018-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package spt.cloud.slack;

import java.io.IOException;
import java.io.UncheckedIOException;

import com.ullink.slack.simpleslackapi.SlackChatConfiguration;
import com.ullink.slack.simpleslackapi.SlackMessageHandle;
import com.ullink.slack.simpleslackapi.SlackPreparedMessage;
import com.ullink.slack.simpleslackapi.SlackSession;
import com.ullink.slack.simpleslackapi.impl.SlackSessionFactory;
import com.ullink.slack.simpleslackapi.replies.SlackMessageReply;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * {@link SlackBot} implementation
 */
@RequiredArgsConstructor
public class SlackBotImpl implements SlackBot {
	
	/**
	 * {@link SlackSession}
	 */
	@NonNull
	private final SlackSession session;
	
	/**
	 * Channel
	 */
	@NonNull
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
	 * @param token token
	 * @param channel {@link #channel}
	 */
	public SlackBotImpl(String token, String channel) {
		
		this(SlackSessionFactory.createWebSocketSlackSession(token), channel);
	}
	
	/**
	 * Connect
	 * 
	 * @throws UncheckedIOException if failed to connect
	 */
	public void connect() throws UncheckedIOException {
		
		if (!this.session.isConnected()) {
			
			try {
				
				this.session.connect();
			}
			catch (IOException e) {
				
				throw new UncheckedIOException("Failed to connect", e);
			}
		}
	}
	
	/**
	 * Disconnect
	 * 
	 * @throws UncheckedIOException if failed to connect
	 */
	public void disconnect() throws UncheckedIOException {
		
		if (this.session.isConnected()) {
			
			try {
				
				this.session.disconnect();
			}
			catch (IOException e) {
				
				throw new UncheckedIOException("Failed to disconnect", e);
			}
		}
	}
	
	@Override
	public String postMessage(String message) {
		
		this.connect();
		
		SlackMessageHandle<SlackMessageReply> handle = this.session.sendMessage(
		/* @formatter:off */
			this.session.findChannelByName(this.channel),
			new SlackPreparedMessage.Builder().withMessage(message).build(),
			SlackChatConfiguration.getConfiguration().asUser()
			/* @formatter:on */
		);
		
		return handle.getReply().getTimestamp();
	}
}
