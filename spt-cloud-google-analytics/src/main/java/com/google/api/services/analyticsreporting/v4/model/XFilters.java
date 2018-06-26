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
 * Custom filters
 */
public class XFilters {
	
	/**
	 * Constructor
	 */
	protected XFilters() {
		
		/* NOP */
	}
	
	/**
	 * OR
	 */
	public static final String OR = ",";
	
	/**
	 * AND
	 */
	public static final String AND = ";";
	
	/**
	 * Not equal
	 */
	public static final String NOT_EQUAL = "!=";
	
	/**
	 * Regular expression equal
	 */
	public static final String REGEX_EQUAL = "=~";
}
