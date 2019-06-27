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
