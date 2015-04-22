package com.java8.dojo.support;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class Person {

	private final String name;
	private final int age;
	private final boolean male;
	private final List<String> hobbies;
	private Random randomGenerator = new Random();

	public Person(String name, int age, boolean isMale, String... hobby) {
		this.age = age;
		this.name = name;
		this.male = isMale;
		this.hobbies = Arrays.asList(hobby);
	}

	public int getAge() {
		return age;
	}

	public boolean isMale() {
		return male;
	}

	public String getName() {
		return name;
	}

	public boolean isAdult() {
		return age >= 18;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public String toString() {
		return String.format("Person[name=%s, age=%s, hobbies=%s]", name, age, hobbies);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((hobbies == null) ? 0 : hobbies.hashCode());
		result = prime * result + (male ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (hobbies == null) {
			if (other.hobbies != null)
				return false;
		} else if (!hobbies.equals(other.hobbies))
			return false;
		if (male != other.male)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public long findReactionTimeMS(){
		 long reactionTime = randomGenerator.nextInt(5000);
		 try {
			Thread.sleep(reactionTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		return reactionTime;
	}

}
