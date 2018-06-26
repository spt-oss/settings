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

package com.google.api.services.analyticsreporting.v4.model;

/**
 * Custom {@link Metric}
 */
public class XMetric {
	
	/**
	 * Constructor
	 */
	protected XMetric() {
		
		/* NOP */
	}
	
	/**
	 * ga:pageviews
	 */
	public static final String PAGE_VIEWS = "ga:pageviews";
	
	/**
	 * ga:totalEvents
	 */
	public static final String TOTAL_EVENTS = "ga:totalEvents";
	
	/**
	 * ga:uniquePageviews
	 */
	public static final String UNIQUE_PAGE_VIEWS = "ga:uniquePageviews";
}
