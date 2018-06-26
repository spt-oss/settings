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

package com.google.api.services.analyticsreporting.v4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential; // TODO @checkstyle:ignore
import com.google.api.client.http.HttpRequestInitializer; // TODO @checkstyle:ignore
import com.google.api.client.http.HttpTransport; // TODO @checkstyle:ignore
import com.google.api.client.http.XCompositeHttpRequestInitializer; // TODO @checkstyle:ignore
import com.google.api.client.json.JsonFactory; // TODO @checkstyle:ignore
import com.google.api.services.analyticsreporting.v4.AnalyticsReporting.Builder; // TODO @checkstyle:ignore

/**
 * Utilities for {@link AnalyticsReporting}
 */
public class XAnalyticsReporting {
	
	/**
	 * Constructor
	 */
	protected XAnalyticsReporting() {
		
		/* NOP */
	}
	
	/**
	 * Builder
	 * 
	 * @param transport {@link HttpTransport}
	 * @param jsonFactory {@link JsonFactory}
	 * @param credential {@link Credential}
	 * @param requestInitializers {@link HttpRequestInitializer}
	 * @return {@link Builder}
	 */
	public static Builder builder(HttpTransport transport, JsonFactory jsonFactory, Credential credential,
		HttpRequestInitializer... requestInitializers) {
		
		List<HttpRequestInitializer> compositeInitializers = new ArrayList<>();
		compositeInitializers.add(credential);
		compositeInitializers.addAll(Arrays.asList(requestInitializers));
		
		return builder(transport, jsonFactory, compositeInitializers);
	}
	
	/**
	 * Builder
	 * 
	 * @param transport {@link HttpTransport}
	 * @param jsonFactory {@link JsonFactory}
	 * @param requestInitializers {@link HttpRequestInitializer}
	 * @return {@link Builder}
	 */
	public static Builder builder(HttpTransport transport, JsonFactory jsonFactory,
		HttpRequestInitializer... requestInitializers) {
		
		return builder(transport, jsonFactory, Arrays.asList(requestInitializers));
	}
	
	/**
	 * Builder
	 * 
	 * @param transport {@link HttpTransport}
	 * @param jsonFactory {@link JsonFactory}
	 * @param requestInitializers {@link HttpRequestInitializer}
	 * @return {@link Builder}
	 */
	public static Builder builder(HttpTransport transport, JsonFactory jsonFactory,
		Collection<HttpRequestInitializer> requestInitializers) {
		
		return new Builder(transport, jsonFactory, new XCompositeHttpRequestInitializer(requestInitializers));
	}
}
