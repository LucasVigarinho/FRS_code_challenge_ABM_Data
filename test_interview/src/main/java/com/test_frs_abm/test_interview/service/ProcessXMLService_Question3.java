package com.test_frs_abm.test_interview.service;

public class ProcessXMLService_Question3 {

    public String process(String body) {

        if(body == null && !"".equalsIgnoreCase(body)){
            throw new IllegalArgumentException("Body payload is null");
        }

        System.out.println(body);

        return "Status: 0";

    }
}




