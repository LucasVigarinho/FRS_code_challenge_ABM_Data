package com.test_frs_abm.test_interview.service;

import org.junit.Before;
import org.junit.Test;

public class MyDomParserQuestion2Test {

	MyDomParser_Question2 test;
	String text, textIfNull;
	MyDomParser_Question2 testOneXML, testTwoXML, testThreeXML;



	@Before
	public void init() {
		text = "documentTest.xml";

		textIfNull = null;

		
		testOneXML = new MyDomParser_Question2(text);
		testTwoXML = new MyDomParser_Question2(textIfNull);

	}


	@Test public void setUp() throws Exception {
		test = new MyDomParser_Question2("documentTest.xml");
	}


	@Test(expected = IllegalArgumentException.class)
	public void checkIfArgumentParameterIsNull() {
		testTwoXML.solution();
	}



}
