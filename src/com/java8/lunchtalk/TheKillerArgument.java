package com.java8.lunchtalk;


/**
 * 
 * Flowing with Strams
 * 
 * Get your Stream: from Array | Collection | IO Stream | Files | InfiniteGeneration
 *   .stream
 *   File.lines(...)
 *   Stream.iterate()
 *   Stream.generate(S)
 *   Stream.of(1,2,3,...)
 *
 * Apply 0 or more Lazy Non Terminal Operations
 *   filter(P)
 *2  map(F)
 *1  flatMap()
 *   limit(n)
 *1  distinct()
 *3  parallel()
 *   
 * Apply a Terminal operation
 *   allMatch(P)
 *   anyMatch(P)
 *   toArray()
 *   forEach()
 *   summaryStatistics()
 *   collect(Collectors.toList)
 *   collect(Collectors.groupingBy( P ? : )
 *   reduce(F) - note this return an optional
 *   sorted()
 * 
 * Predicates (and F,C,S)
 *   can be chained, and passed around
 *
 * When ever you are about to write a for/while loop, STOP and think how to do this with a Stream instead
 */
public class TheKillerArgument {

}
