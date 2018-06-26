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

import java.util.List;

import lombok.NonNull;

/**
 * Custom {@link ReportRow}
 */
public class XReportRow {
	
	/**
	 * {@link ColumnHeader}
	 */
	private ColumnHeader header;
	
	/**
	 * {@link ReportRow}
	 */
	private ReportRow row;
	
	/**
	 * Constructor
	 * 
	 * @param header {@link ColumnHeader}
	 * @param row {@link ReportRow}
	 */
	public XReportRow(@NonNull ColumnHeader header, @NonNull ReportRow row) {
		
		this.header = header;
		this.row = row;
	}
	
	/**
	 * Extract dimension
	 * 
	 * @param name name
	 * @return value
	 * @throws IllegalArgumentException if not found
	 */
	public String getDimension(String name) throws IllegalArgumentException {
		
		List<String> names = this.header.getDimensions();
		List<String> dimensions = this.row.getDimensions();
		
		for (int i = 0; i < names.size() && i < dimensions.size(); i++) {
			
			if (names.get(i).equals(name)) {
				
				return dimensions.get(i);
			}
		}
		
		throw new IllegalArgumentException("Dimension not found: " + name);
	}
	
	/**
	 * Get metric
	 * 
	 * @param name name
	 * @return value
	 * @throws IllegalArgumentException if not found
	 */
	public String getMetric(String name) throws IllegalArgumentException {
		
		List<MetricHeaderEntry> names = this.header.getMetricHeader().getMetricHeaderEntries();
		List<DateRangeValues> metrics = this.row.getMetrics();
		
		for (int i = 0; i < metrics.size(); i++) {
			
			DateRangeValues values = metrics.get(i);
			
			for (int j = 0; j < values.getValues().size() && j < names.size(); j++) {
				
				if (names.get(j).getName().equals(name)) {
					
					return values.getValues().get(j);
				}
			}
		}
		
		throw new IllegalArgumentException("Metric not found: " + name);
	}
}
