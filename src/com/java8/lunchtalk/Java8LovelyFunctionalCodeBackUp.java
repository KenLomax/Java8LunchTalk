package com.java8.lunchtalk;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

import com.java8.dojo.support.Person;

public class Java8LovelyFunctionalCodeBackUp {

	/**
	 * Streams are an abstraction above Collections, that take:
	 *    perhaps a sequence LAZY operations and
	 *    one final operation
	 */
		
	@Test
	public void modifyingDataToUpperCase() {
		// Get the Data
		Stream<String> myData = Stream.of("i", "love", "icke");
		
		// Do something with the Data
		List<String> myModifiedData =
				myData.
				map( s-> s.toUpperCase() ).		// Map a function to each element
				collect(Collectors.toList());	// Collect the result
		
		// Check the answer
		assertEquals(myModifiedData, Arrays.asList("I", "LOVE", "ICKE"));
	}


	/**
	 * Look at the Stream Flow Table and use that as a guideline
	 */
	@Test
	public void filteringData() {
		// Get the Data
		Stream<String> myData = Stream.of("lin", "cant", "play", "football");
		
		// Do something with the Data
		List<String> myModifiedData =
				myData.
				filter( s -> s.contains("a")).	// Filter it with a function
				collect(Collectors.toList());	// Collect the result
		
		// Check the answer
		assertEquals(myModifiedData, Arrays.asList("cant", "play" , "football"));
	}

	@Test
	public void sortingData() {
		// Get the Data
		List<String> myData = Arrays.asList("lilits", "beautiful", "piggy");
		
		// Do something with the Data
		List<String> myModifiedData =
			myData.
			stream().								// Get the Stream abstraction of this collection
			sorted( (s1,s2) -> s2.compareTo(s1) ).	// Sort it with a function
			collect(Collectors.toList());			// Collect the result
		
		// Check the answer
		assertEquals(myModifiedData, Arrays.asList("piggy", "lilits", "beautiful"));
	}

	@Test
	public void aggregatingDataCheckAllAreOdd() {
		// Get the Data
		Stream<Integer> myData= Stream.of(1, 3, 5, 7, 9, 12);
	
		boolean allOdd = 
				myData.
				allMatch( i -> i%2 == 1 ); // Apply a function to all members
		
		// Check the answer
		assertFalse(allOdd);	
	}
	
	@Test
	public void aggregatingDataIntoEvenAndOdd() {
		// Get the Data
		Stream<Integer> myData = Stream.of(1, 3, 5, 7, 9, 12);
		
		Map <String, List<Integer>> m = myData.
			collect( 
				Collectors.
					groupingBy( i->i%2==0 ? "even" : "odd"  ));

		// Check the answer
		assertEquals(m.get("odd"), Arrays.asList(1,3,5,7,9));
		assertEquals(m.get("even"), Arrays.asList(12));
	}



	@Test 
	public void summingACollection(){
		// Get the Data
		Stream<Integer> myData = Stream.of(1, 3, 5, 7, 9, 12);
		
		int total = myData.
				reduce( (a,b)->a+b ). 	// Apply a reduction function
				get(); 					// And return the result
		
		// Check the answer
		assertEquals( total, 37 );
		
		IntStream is = IntStream.of(1,3,5,7,9,12);
		System.out.println(is.summaryStatistics());
	}

	/////////////////////////////////////////////////////////
	// What's going on?
	// Flowing with Streams - Get, Lazy Ops, Terminal Ops..
	// The 4 Types of math functions we can apply to Streams
	// Functional Interfaces, compiler, Lambdas
	// Lazy non terminal methods
	/////////////////////////////////////////////////////////
	
	@Test
	public void infiniteStreams(){
		// Get an infinite Stream (no out of memory, no taking for ever..)
		// Stream.iterate( 0, a->a+1 ).forEach( n-> System.out.println(n));
		
		// Lazy functions 
		//Stream.iterate( 0, a->a+1 ).filter( n -> n%2==0).forEach( n-> System.out.println(n));
	}


	
	@Test 
	public void intStreams(){
		System.out.println(IntStream.of(1,2,3,4,5,6,7,8,9).summaryStatistics());
	}
	
	@Test 
	public void debuggingLazinessWithPeak(){ // See these lazy bastards in action
		IntStream.of(1,2,3,4,5,6,7,8,9).
		filter(n->n%2==0).
		peek( n-> System.out.println(n) ).
		filter(n->n%4==0);
		//forEach(n-> System.out.println(n) )
		//;
	}
	
	@Test
	public void someThingWithFlatMap(){	
		Stream.of( 
				new Person("Jack", 31, true, "Sailing", "Cycling"),
				new Person("Benjamin", 12, true, "Playing Piano"),
				new Person("Suse", 37, false, "Sailing", "Swimming")
				).
		map( p -> p.getHobbies().stream()).
		collect( Collectors.toList());
	}
	
	
	@Test
	public void parallelStreams(){
		System.out.println( Stream.of( 
				new Person("Jack", 31, true, "Sailing", "Cycling"),
				new Person("Benjamin", 12, true, "Playing Piano"),
				new Person("Suse", 37, false, "Sailing", "Swimming")
				).
				//parallel().
				map(p -> p.findReactionTimeMS()).
				reduce(0l,(x,y)->x+y)
		);
	}
	
}
