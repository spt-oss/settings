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

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * {@link Test}: {@link SlackBot}
 */
@RunWith(SpringRunner.class)
// TODO
// @SpringBootTest(classes = SlackConfiguration.class)
@ActiveProfiles("test")
public class SlackBotTests {
	
	/**
	 * {@link SlackBot}
	 */
	@Autowired
	private SlackBot bot;
	
	/**
	 * {@link SlackBot#postMessage(String)}
	 */
	@Ignore
	@Test
	public void postMessage() {
		
		this.bot.postMessage("Test message");
	}
}