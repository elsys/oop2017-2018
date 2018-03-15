package org.elsys;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Name {

	private String firstName;
	private String lastName;

	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
/*
	@Override
	public boolean equals(Object other) {
		Name on = (Name) other;
		return firstName.equals(on.firstName) && 
				lastName.equals(on.lastName);
	}
	
	@Override
	public int hashCode() {
		return firstName.hashCode() + 37 * lastName.hashCode();
	}
*/
	
	public static void main(String[] args) {
		Name n1 = new Name("pesho", "peshef");
		Name n2 = new Name("ivan", "ivanov");
		
		List<Name> names = new ArrayList<Name>();
		
		names.add(n1);
		names.add(n2);
		
		System.out.println(names.contains(n1));
		System.out.println(names.contains(n2));

		System.out.println(names.contains(
				new Name("ivancho", "ivanchev")));
		
		System.out.println(names.contains(
				new Name("ivan", "ivanov")));
		
		Name n3 = new Name("ivan", "ivanov");
		Name n33 = n3;
		
		System.out.println(" 1 == 1  -> " + (1==1));
		System.out.println("n2 == n3 -> " + (n2 == n3));
		System.out.println("n3 == n33-> " + (n3 == n33));
		System.out.println("n2.equals(n3)-> " + (n2.equals(n3)));
		
		
		Set<Name> namesSet = new HashSet<Name>();
		namesSet.add(n1);
		namesSet.add(n2);
		
		
		System.out.println(namesSet.contains(n1));
		System.out.println(namesSet.contains(n2));
		System.out.println(namesSet.contains(n3));
		
		System.out.println("ala bala".hashCode());
		System.out.println("ala bala portokala".hashCode());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		Name other = (Name) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

}
