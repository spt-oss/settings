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

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Objects; // TODO @checkstyle:ignore

import lombok.NonNull;

/**
 * Custom {@link Report}
 */
public class XReport {
	
	/**
	 * Constructor
	 */
	protected XReport() {
		
		/* NOP */
	}
	
	/**
	 * Get {@link XReportRow}
	 * 
	 * @param report {@link Report}
	 * @return {@link XReportRow}
	 */
	public static List<XReportRow> getRows(@NonNull Report report) {
		
		List<XReportRow> rows = new ArrayList<>();
		
		for (ReportRow row : Objects.firstNonNull(report.getData().getRows(), new ArrayList<ReportRow>())) {
			
			rows.add(new XReportRow(report.getColumnHeader(), row));
		}
		
		return rows;
	}
}
