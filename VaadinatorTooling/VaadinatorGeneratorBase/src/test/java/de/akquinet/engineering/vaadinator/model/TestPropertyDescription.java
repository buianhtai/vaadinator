/*
 * Copyright 2016 Daniel Norhoff-Vergien
 *  
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package de.akquinet.engineering.vaadinator.model;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

public class TestPropertyDescription {

	private PropertyDescription propertyDescriptionUnderTest;

	@Before
	public void setUp() {
		propertyDescriptionUnderTest = new PropertyDescription();
	}

	@Test
	public void testGetPropertyClassTypeParameter() {
		propertyDescriptionUnderTest.setPropertyClassName("List<String>");
		assertThat(propertyDescriptionUnderTest.getPropertyClassTypeParameter(), is("String"));
	}

	@Test
	public void testGetPropertyClassWithoutTypeParameter() {
		propertyDescriptionUnderTest.setPropertyClassName("List<String>");
		assertThat(propertyDescriptionUnderTest.getPropertyClassWithoutTypeParameter(), is("List"));
	}
	
	@Test
	public void testGetPropertyClassNameBoxedWithoutTypeParameter() {
		propertyDescriptionUnderTest.setPropertyClassName("List<Integer>");
		assertThat(propertyDescriptionUnderTest.getPropertyClassNameBoxedWithoutTypeParameter(), is("List"));
		
		propertyDescriptionUnderTest.setPropertyClassName("int");
		assertThat(propertyDescriptionUnderTest.getPropertyClassNameBoxedWithoutTypeParameter(), is("Integer"));
	}
	
	
}
