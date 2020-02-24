package com.test_frs_abm.test_interview.service;
import java.util.Arrays;
public class Frc_Abm_Java_XML_Question1 {

	private String text;

	Frc_Abm_Java_XML_Question1(String text){
		this.text = text;
	}
	/** The main method in order to test all the variables and methods created */
	public static void main(String[] args) {

		/** Created a test adopting the String text available on the instructions */
		String text = "UNA:+.? '\n" + 
				"UNB+UNOC:3+2021000969+4441963198+180525:1225+3VAL2MJV6EH9IX+KMSV7HMD+CUSDECU-IE++1++1'\n" + 
				"UNH+EDIFACT+CUSDEC:D:96B:UN:145050'\n" + 
				"BGM+ZEM:::EX+09SEE7JPUV5HC06IC6+Z'\n" + 
				"LOC+17+IT044100'\n" + 
				"LOC+18+SOL'\n" + 
				"LOC+35+SE'\n" + 
				"LOC+36+TZ'\n" + 
				"LOC+116+SE003033'\n" + 
				"DTM+9:20090527:102'\n" + 
				"DTM+268:20090626:102'\n" + 
				"DTM+182:20090527:102'\n" + 
				"";			

		Frc_Abm_Java_XML_Question1 test = new Frc_Abm_Java_XML_Question1(text);

		/** Created myArray of String to absorb the answer*/
		String [] myArray = test.locEdiFact();

		System.out.print(Arrays.toString(myArray));


	}//closing the main method

	/**1.	Taking the following EDIFACT message text, 
	 * 		write some code to parse out the all the LOC segments and
	 *  	populate an array with the 2nd and 3rd element of each segment.  
	 *  */
	/** Created a method which is going to receive a String and give back an Array 
	 * 	with the 2nd and 3rd element of each segment 
	 * 
	 * 	Note:  the ‘+’ is an element delimiter   */
	public  String[] locEdiFact(){

		/** Created an if statement in order to verify the possibility of NULL or empty String*/
		if(text == null && !"".equalsIgnoreCase(text)){
			throw new IllegalArgumentException("Text parameter is empty or null");
		}
		/** Created an if statement in order to verify the possibility of no LOC in the String*/
		if(!text.contains("LOC")){
			throw new IllegalArgumentException("LOC segment not found");
		}
		/** Created an array, in order to absorb the String which is going to be divided,
		 *  using the first delimiter - jumping line ("\n") */
		String [] newOne = this.text.split("\n");
		String [] answer = new String [10];
		int count = 0;

		/** Created a for loop, in order to verify all the positions of the newOne Array */
		for(int i = 0; i < newOne.length ; i++) {


			/** Created an array called item, which will absorb the value of which position 
			 * array subdivided again, now using the new delimited "+" sign. */
			String [] item = newOne[i].split("\\+");

			/** Created an if statement in order to verify if the first position of the array, 
			 * is the LOC String */
			if(item[0].equals("LOC")) {
				String [] itemClean = item[2].split("\\'");
				answer [count++] = item[1];
				answer [count++] = itemClean[0];
			}//closing if statement
		}//closing first for loop 
		return answer;
	}//closing locEdiFact method
}//closing the Frc_Abm_Java_XML class
