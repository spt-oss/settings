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

package com.google.api.client.googleapis.auth.oauth2;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Collection;

import com.google.api.client.auth.oauth2.Credential; // TODO @checkstyle:ignore
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential.Builder; // TODO @checkstyle:ignore
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport; // TODO @checkstyle:ignore
import com.google.api.client.http.HttpRequestInitializer; // TODO @checkstyle:ignore
import com.google.api.client.http.HttpTransport; // TODO @checkstyle:ignore
import com.google.api.client.http.XCompositeHttpRequestInitializer; // TODO @checkstyle:ignore
import com.google.api.client.json.JsonFactory; // TODO @checkstyle:ignore

/**
 * Custom {@link GoogleCredential}
 */
public class XGoogleCredential {
	
	/**
	 * Constructor
	 */
	protected XGoogleCredential() {
		
		/* NOP */
	}
	
	/**
	 * {@link GoogleNetHttpTransport#newTrustedTransport()}
	 * 
	 * @param credentialStream credential {@link InputStream}
	 * @param transport {@link HttpTransport}
	 * @param jsonFactory {@link JsonFactory}
	 * @return {@link GoogleCredential}
	 * @throws IllegalStateException if failed to instantiate
	 */
	public static GoogleCredential fromStream(InputStream credentialStream, HttpTransport transport,
		JsonFactory jsonFactory) throws IllegalStateException {
		
		try {
			
			return GoogleCredential.fromStream(credentialStream, transport, jsonFactory);
		}
		catch (IOException e) {
			
			throw new IllegalStateException("Failed to instantiate", e);
		}
	}
	
	/**
	 * {@link Builder#setRequestInitializer(HttpRequestInitializer)} for {@link GoogleCredential}
	 * 
	 * @param credential {@link GoogleCredential}
	 * @param requestInitializers {@link HttpRequestInitializer}
	 * @throws IllegalStateException if failed to set
	 */
	public static void setRequestInitializer(GoogleCredential credential, HttpRequestInitializer... requestInitializers)
		throws IllegalStateException {
		
		try {
			
			Field field = Credential.class.getDeclaredField("requestInitializer");
			field.setAccessible(true);
			field.set(credential, new XCompositeHttpRequestInitializer(requestInitializers));
		}
		catch (ReflectiveOperationException | SecurityException e) {
			
			throw new IllegalStateException("Could not set value to 'requestInitializer' field", e);
		}
	}
	
	/**
	 * {@link Builder#setServiceAccountScopes(Collection)} for {@link GoogleCredential}
	 * 
	 * @param credential {@link GoogleCredential}
	 * @param scopes scopes
	 * @throws IllegalStateException if failed to set
	 */
	public static void setServiceAccountScopes(GoogleCredential credential, Collection<String> scopes)
		throws IllegalStateException {
		
		try {
			
			Field field = GoogleCredential.class.getDeclaredField("serviceAccountScopes");
			field.setAccessible(true);
			field.set(credential, scopes);
		}
		catch (ReflectiveOperationException | SecurityException e) {
			
			throw new IllegalStateException("Could not set value to 'serviceAccountScopes' field", e);
		}
	}
}
