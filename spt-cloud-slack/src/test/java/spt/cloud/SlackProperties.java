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
