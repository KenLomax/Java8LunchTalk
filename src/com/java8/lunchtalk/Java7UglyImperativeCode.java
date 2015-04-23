package com.java8.lunchtalk;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

/**
 * Typical life of a Developer:
 * 		Get Data -> 
 * 		Do something with the data (Filtering, Modifying, Adding, ) -> 
 * 		Return the Answer
 */
public class Java7UglyImperativeCode {
	
	@Test
	public void modifyingDataToUpperCase() {
		// Get the Data
		List<String> myData = Arrays.asList("i", "love", "icke");
		
		// Do something with the Data
		List<String> myModifiedData = new ArrayList<>();	// Even in this trivial case we have messy code..
		for (int i = 0; i< myData.size(); i++){  			// Explicit iteration
			String s = myData.get(i);			 			// Mutable Data
			s = s.toUpperCase(); 							// Our business logic is hidden here amongst the noise	
			myModifiedData.add( s );  						// Mutable Data
		}

		// Check the answer
		assertEquals(myModifiedData, Arrays.asList("I", "LOVE", "ICKE"));
	}
	
	
	
	
	
	

	@Test
	public void filteringData() {
		// Get the Data
		List<String> myData = Arrays.asList("lin", "cant", "play", "football");
		
		// Do something with the Data
		List<String> myModifiedData = new ArrayList<>();	// Even in this trivial case we have messy code..
		for (String s : myData) {							// Slightly *better* iteration style, but still explicit 
			if (s.contains("a")) {							// Our business logic is hidden here amongst the noise
				myModifiedData.add(s);  					// Mutable Data
			}
		}

		// Check the answer
		assertEquals(myModifiedData, Arrays.asList("cant", "play" , "football"));

		/*
		 * Problems with java 7 approaches: Mutable data - hard to parallelise
		 * Lot of noise - hard to see business logic and maintain code Explicit
		 * iteration
		 */
	}
	
	
	
	
	
	@Test
	public void toLowerCaseAndThenFilter() {
		// Get the Data
		List<String> myData = Arrays.asList("Angela", "Merkel", "Is","Sexy");
		
		// Do something with the Data
		List<String> myModifiedData = new ArrayList<>();	// Even in this trivial case we have messy code..
		for (int i = 0; i< myData.size(); i++){  			// Explicit iteration
			String s = myData.get(i);			 			// Mutable Data
			s = s.toLowerCase(); 							// Our business logic is hidden here amongst the noise	
			if (s.contains("e"))							// Unclear, spaghetti
				myModifiedData.add( s );  					// Mutable Data
		}
		
		// Check the answer
		assertEquals(myModifiedData, Arrays.asList("angela","merkel","sexy"));
	}
	
	
	
	
	
	

	@Test
	public void sortingData() {
		// Get the Data
		List<String> myData = Arrays.asList("lilits", "beautiful", "piggy");
		
		// Do something with the Data								// What!? 
		Collections.sort(myData, new Comparator<String>() {			// Just to sort data.. We have to make an anonymous inner class..
			@Override
			public int compare(String string1, String string2) {	// and override a method
				return string2.compareTo(string1);					// and Finally we can add our business logic
			}
		});
		
		// Check the answer
		assertEquals(myData, Arrays.asList("piggy", "lilits", "beautiful"));
	}
	
	
	
	
	
	
	
	

	@Test
	public void aggregatingDataCheckAllAreOdd() {
		// Get the Data
		List<Integer> myData = Arrays.asList(1, 3, 5, 7, 9, 12);
		
		// Do something with the Data: check that all numbers are odd
		boolean allOdd = true;
		for (int i : myData) {			// Explicit iteration
			if (i % 2 == 0) {			// BUsiness logic hidden here 
				allOdd = false;			//   and here
				break;					// Spaghetti code
			}
		}

		// Check the answer
		assertFalse(allOdd);
	}
	
	
	
	
	
	
	
	
	
	@Test
	public void aggregatingDataIntoEvenAndOdd() {
		// Get the Data
		List<Integer> myData = Arrays.asList(1, 3, 5, 7, 9, 12);
		
		// Do something with the Data: split into even and odd collections
		List<Integer> oddData = new ArrayList<Integer>();
		List<Integer> evenData = new ArrayList<Integer>();
		for (int i : myData) {			// Explicit iteration
			if (i % 2 == 1) 			// Business logic hidden over these lines
				oddData.add(i);
			else
				evenData.add(i);
		}
		
		// Check the answer
		assertEquals(oddData, Arrays.asList(1,3,5,7,9));
		assertEquals(evenData, Arrays.asList(12));
	}
	
	
	
	
	
	
	
	

	@Test 
	public void summingACollection(){
		// Get the Data
		List<Integer> myData = Arrays.asList(1, 3, 5, 7, 9, 12);
		
		// Do something with the Data: add the numbers up..
		int total = 0;
		for (int i:myData){		// Explicit Iteration
			total += i;			// Mutable data
		}
		
		// Check the answer
		assertEquals( total, 37 );
	}


}
