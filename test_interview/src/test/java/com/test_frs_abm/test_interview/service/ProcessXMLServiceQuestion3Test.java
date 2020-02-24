package com.test_frs_abm.test_interview.service;

import org.junit.Before;
import org.junit.Test;

public class ProcessXMLServiceQuestion3Test {

    ProcessXMLService_Question3 processXMLServiceQuestion3;

    @Before
    public void setUp() throws Exception {
        processXMLServiceQuestion3 = new ProcessXMLService_Question3();
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkIfBodyResponseIsNull() {
        processXMLServiceQuestion3.process(null);
    }
}