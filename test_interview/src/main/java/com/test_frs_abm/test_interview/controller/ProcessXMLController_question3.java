package com.test_frs_abm.test_interview.controller;

import com.test_frs_abm.test_interview.service.ProcessXMLService_Question3;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessXMLController_question3 {


    @GetMapping(path = "/test")
    public ResponseEntity getTest() {
            return ResponseEntity.status(200).body ("Status: 0");
//            return ResponseEntity.status(400).body ("Status: -1");
//            return ResponseEntity.status(400).body ("Status: -2");

//        return "Test response";
    }
    /** TO BE PAST ON POSTMAN. - (POST) - Body (raw) - localhost:8080/test */
    /** <InputDocument>
     <DeclarationList>
     <Declaration Command="DEFAULT" Version="5.13">
     <DeclarationHeader>
     <Jurisdiction>IE</Jurisdiction>
     <CWProcedure>IMPORT</CWProcedure>
     <DeclarationDestination>CUSTOMSWAREIE</DeclarationDestination>
     <DocumentRef>71Q0019681</DocumentRef>
     <SiteID>DUB</SiteID>
     <AccountCode>G0779837</AccountCode>
     </DeclarationHeader>
     </Declaration>
     </DeclarationList>
     </InputDocument>
     */
    @PostMapping(path = "/test")
    public ResponseEntity getTest(@RequestBody String body) {

        ProcessXMLService_Question3 processXMLServiceQuestion3 = new ProcessXMLService_Question3();
        String statusResponse = "";
        try{
            statusResponse = processXMLServiceQuestion3.process(body);
            return ResponseEntity.status(200).body(statusResponse);

        }catch(IllegalArgumentException e){
            return ResponseEntity.status(400).body(statusResponse);
        }

//        return "Test response";
    }
}
