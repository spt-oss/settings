/*
 * Copyright 2017 the original author or authors.
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

package com.google.api.client.http;

import java.io.IOException;

import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Simple {@link HttpRequestInitializer}
 */
public class XSimpleHttpRequestInitializer implements HttpRequestInitializer {
	
	/**
	 * {@link HttpRequest#getConnectTimeout()}
	 */
	@Setter
	@Accessors(chain = true)
	private int connectTimeout = 20 * 1000;
	
	/**
	 * {@link HttpRequest#getReadTimeout()}
	 */
	@Setter
	@Accessors(chain = true)
	private int readTimeout = 20 * 1000;
	
	/**
	 * {@link HttpRequest#getNumberOfRetries()}
	 */
	@Setter
	@Accessors(chain = true)
	private int numberOfRetries = HttpRequest.DEFAULT_NUMBER_OF_RETRIES;
	
	@Override
	public void initialize(@NonNull HttpRequest request) throws IOException {
		
		request.setConnectTimeout(this.connectTimeout);
		request.setReadTimeout(this.readTimeout);
		request.setNumberOfRetries(this.numberOfRetries);
	}
}
