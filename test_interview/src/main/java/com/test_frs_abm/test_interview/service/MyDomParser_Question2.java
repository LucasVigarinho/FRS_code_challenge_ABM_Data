/**
 * 
 */
package com.test_frs_abm.test_interview.service;

/**
 * @author lucasmaximo
 *
 */
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/** Created the MyDomParser class */
public class MyDomParser_Question2 {
	
	private String text;
	
	MyDomParser_Question2(String text){
		this.text = text;
	}

	/** Created the main class */
	public static void main(String[] args) {
		MyDomParser_Question2 test = new MyDomParser_Question2("documentTest.xml");
		test.solution();
	}

	/** Created the method in order to extract the information form xml*/
	public void solution() {
		/** Instantiate a new SocumentBuilderFactory*/
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		
		/** Created an if statement in order to verify the possibility of NULL or empty String*/
		if(text == null && !"".equalsIgnoreCase(text)){
			throw new IllegalArgumentException("Text parameter is empty or null");
		}
		
		//surround the first try catch in order to catch if the document out of pattern
		try {
			//build a document 
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(text);
			//Stipulate the node
			NodeList refList = document.getElementsByTagName("Reference");
			//look for all the nodes with the same reference
			for(int i = 0; i < refList.getLength(); i++) {
				//verify item from the reference node
				Node code = refList.item(i);
				//verify element
				Element codeElement = (Element) code;
				//check the attribute using if statement
				String codeDecript = codeElement.getAttribute("RefCode");
				if(("MWB").equalsIgnoreCase(codeDecript) || ("TRV").equalsIgnoreCase(codeDecript) || ("CAR").equalsIgnoreCase(codeDecript)) {
					//print all the child nodes after checked
					NodeList text = codeElement.getChildNodes();
					for(int j = 0; j < text.getLength(); j++) {
						//verify the item from the node
						Node info = text.item(j);
						System.out.print("\t" + info.getTextContent());//print out the text content
					}//closing the nested for loop
				}//closing the if statement
			}//closing the main for loop
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}//closing solution method 

}//closing the MyDomParser class
