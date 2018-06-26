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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Composite {@link HttpRequestInitializer}
 */
public class XCompositeHttpRequestInitializer implements HttpRequestInitializer {
	
	/**
	 * {@link HttpRequestInitializer}
	 */
	private List<HttpRequestInitializer> initializers;
	
	/**
	 * Constructor
	 * 
	 * @param initializers {@link HttpRequestInitializer}
	 */
	public XCompositeHttpRequestInitializer(HttpRequestInitializer... initializers) {
		
		this(Arrays.asList(initializers));
	}
	
	/**
	 * Constructor
	 * 
	 * @param initializers {@link HttpRequestInitializer}
	 */
	public XCompositeHttpRequestInitializer(Collection<HttpRequestInitializer> initializers) {
		
		this.initializers = new ArrayList<>(initializers);
	}
	
	@Override
	public void initialize(HttpRequest request) throws IOException {
		
		for (HttpRequestInitializer initializer : this.initializers) {
			
			initializer.initialize(request);
		}
	}
}
